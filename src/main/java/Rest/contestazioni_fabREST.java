package Rest;

import DTO.ErrorResponse;
import DTO.contestazioni_fabDTO;
import DTO.contestazioni_fondovalleDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.List;

@Path("fab")
@Data
public class contestazioni_fabREST {
    @Inject
    DAO.contestazioni_fabDAO contestazioni_fabDAO;

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
    public List<contestazioni_fabDTO> GetContestazioni_fab() {
        return contestazioni_fabDAO.getDataFab();
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
    public List<contestazioni_fabDTO> addContestazione_fab(contestazioni_fabDTO contestazione) {

        if (!contestazioni_fabDAO.findContestazione_fab(contestazione))
            contestazioni_fabDAO.addContestazione_fab(contestazione);
        else
            throw new WebApplicationException(
                    Response.status(Response.Status.CONFLICT)
                            .entity(ErrorResponse.getError("409", "Conflict"))
                            .type(MediaType.APPLICATION_JSON)
                            .build()
            );
        return contestazioni_fabDAO.getDataFab();
    }

    @Path("/delete/{id}")
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
    public void delContestazione_elios(@PathParam("id") String id) {
        contestazioni_fabDAO.deleteContestazione_fab(id);
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
    public List<contestazioni_fabDTO> updateContestazioni_fab(@PathParam("id") String id, contestazioni_fabDTO contestazione) {
        //id serve per identificare la contestazione che vogliamo aggiornare
        contestazioni_fabDAO.updateContestazioni_fab(contestazione, id);

        return contestazioni_fabDAO.getDataFab();
    }
}
