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


@Path("contart")
@Data
public class cont_art_italcerREST {
    @Inject
    cont_art_italcerDAO cont_art_italcerDAO;

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
    @SuppressWarnings("unused")
    public List<cont_art_italcerDTO> Getcont_art_italcer() {
        return cont_art_italcerDAO.getData();
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
    @SuppressWarnings("unused")
    public List<cont_art_italcerDTO> addContestazione_elios(cont_art_italcerDTO contestazione) {

        if (!cont_art_italcerDAO.findCont_art_Italcer(contestazione))
            cont_art_italcerDAO.addCont_art_italcer(contestazione);
        else
            throw new WebApplicationException(
                    Response.status(Response.Status.CONFLICT)
                            .entity(ErrorResponse.getError("409", "Conflict"))
                            .type(MediaType.APPLICATION_JSON)
                            .build()
            );
        return cont_art_italcerDAO.getData();
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
    @SuppressWarnings("unused")
    public List<cont_art_italcerDTO> delContestazione_elios(cont_art_italcerDTO contestazione) {

        if (cont_art_italcerDAO.findCont_art_Italcer(contestazione)) {
            cont_art_italcerDAO.deleteCont_art_italcer(contestazione);
        } else {
            throw new WebApplicationException(
                    Response.status(Response.Status.CONFLICT)
                            .entity(ErrorResponse.getError("409", "Conflict"))
                            .type(MediaType.APPLICATION_JSON)
                            .build()
            );
        }
        return cont_art_italcerDAO.getData();
    }

    @Path("/update/{id_cont}")
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
    @SuppressWarnings("unused")
    public List<cont_art_italcerDTO> updatecont_art_italcer(@PathParam("id_cont") String id_cont, cont_art_italcerDTO contestazione) {
        //id serve per identificare la contestazione che vogliamo aggiornare
        cont_art_italcerDAO.updatecont_art_italcer(contestazione, id_cont);

        return cont_art_italcerDAO.getData();
    }
}
