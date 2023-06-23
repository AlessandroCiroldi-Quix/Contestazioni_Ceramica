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
import Entity.*;

import java.util.List;

@Path("data")
@Data
public class contestazioniREST {
    @Inject
    contestazioni_italcerDAO contestazioni_italcerDAO;

    @Path("/get")
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
    public List<contestazioni_italcerDTO> GetContestazioni_italcer(){ return contestazioni_italcerDAO.getData(); }

    @Path("/addContestazione_italcer")
    @PUT
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
    public List<contestazioni_italcerDTO> addContestazione_italcer(contestazioni_italcerDTO contestazione){

        if(!contestazioni_italcerDAO.findContestazione_italcer(contestazione))
            contestazioni_italcerDAO.addContestazione_italcer(contestazione);
        else
            throw new WebApplicationException(
                    Response.status(Response.Status.CONFLICT)
                            .entity(ErrorResponse.getError("409","Conflict"))
                            .type(MediaType.APPLICATION_JSON)
                            .build()
            );
        return contestazioni_italcerDAO.getData();
    }

    @Path("/remove")
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
    public List<contestazioni_italcerDTO> delContestazione_italcer(contestazioni_italcerDTO contestazione){

        if(contestazioni_italcerDAO.findContestazione_italcer(contestazione)){
                contestazioni_italcerDAO.deleteContestazione_italcer(contestazione);
            }else {
                throw new WebApplicationException(
                        Response.status(Response.Status.CONFLICT)
                                .entity(ErrorResponse.getError("409", "Conflict"))
                                .type(MediaType.APPLICATION_JSON)
                                .build()
                );
            }
        return contestazioni_italcerDAO.getData();
    }

    @Path("/update/{cod}") //! da modificare in seguito
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
    public List<contestazioni_italcerDTO> updateContestazioni_italcer(@PathParam("cod") String cod, contestazioni_italcerDTO contestazione){

        contestazioni_italcerDAO.updateContestazioni_italcer(contestazione, contestazione.getCod_cliente());

        return contestazioni_italcerDAO.getData();
    }
}
