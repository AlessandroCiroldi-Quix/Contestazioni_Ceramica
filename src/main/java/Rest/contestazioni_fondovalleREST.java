package Rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import DAO.*;
import DTO.*;

import java.util.List;

@Path("fondovalle")
@Data
public class contestazioni_fondovalleREST {
    @Inject
    contestazioni_fondovalleDAO contestazioni_fondovalleDAO;

    @Path("/select")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {

            @APIResponse(
                    responseCode = "500",
                    description = "Errore",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),

            @APIResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),

            @APIResponse(
                    responseCode = "200",
                    description = "OK")}
    )
    public List<contestazioni_fondovalleDTO> GetContestazioni_fondovalle() {
        return contestazioni_fondovalleDAO.getDataFondovalle();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "500",
                    description = "Errore",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "Conflict",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "OK")}
    )
    //questo metodo controlla se esiste già la contestazione, se esiste lancia un errore,
    //se non esiste lo aggiunge e poi fa una select dei dati aggiornati
    public List<contestazioni_fondovalleDTO> addContestazione_fondovalle(contestazioni_fondovalleDTO contestazione) {

        if (!contestazioni_fondovalleDAO.findContestazione_fondovalle(contestazione))
            contestazioni_fondovalleDAO.addContestazione_fondovalle(contestazione);
        else
            throw new WebApplicationException(
                    Response.status(Response.Status.CONFLICT)
                            .entity(ErrorResponse.getError("409", "Conflict"))
                            .type(MediaType.APPLICATION_JSON)
                            .build()
            );
        return contestazioni_fondovalleDAO.getDataFondovalle();
    }

    @Path("/delete")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "500",
                    description = "Errore",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "not fnd",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "Conflict",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "OK")}
    )
    public List<contestazioni_fondovalleDTO> delContestazione_fondovalle(contestazioni_fondovalleDTO contestazione) {

        if (contestazioni_fondovalleDAO.findContestazione_fondovalle(contestazione)) {
            contestazioni_fondovalleDAO.deleteContestazione_fondovalle(contestazione);
        } else {
            throw new WebApplicationException(
                    Response.status(Response.Status.CONFLICT)
                            .entity(ErrorResponse.getError("409", "Conflict"))
                            .type(MediaType.APPLICATION_JSON)
                            .build()
            );
        }
        return contestazioni_fondovalleDAO.getDataFondovalle();
    }

    @Path("/update/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "500",
                    description = "Errore",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(
                    responseCode = "409",
                    description = "Conflict",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "OK")}
    )
    public List<contestazioni_fondovalleDTO> updateContestazioni_fondovalle(@PathParam("id") String id, contestazioni_fondovalleDTO contestazione) {
        //id serve per identificare la contestazione che vogliamo aggiornare
        contestazioni_fondovalleDAO.updateContestazioni_fondovalle(contestazione, id);

        return contestazioni_fondovalleDAO.getDataFondovalle();
    }
}


