package Rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import DAO.*;
import DTO.*;
import Entity.*;

import java.util.List;

@Path("data") //NOME DA RIVEDERE
@Data
public class contestazioniREST {
    @Inject
    contestazioni_italcerDAO contestazioni_italcerDAO;

    @Path("/artisti")
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
    public List<contestazioni_italcerDTO> GetArtist(){
        return contestazioni_italcerDAO.getData();
    }
}
