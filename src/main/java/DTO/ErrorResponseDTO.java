package DTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class ErrorResponseDTO {
    private boolean error;
    private String type;
    private String msg;

    public ErrorResponseDTO(String type, String msg) {
        this.error = true;
        this.type = type;
        this.msg = msg;
    }

    public static String getError(String type, String msg) {
        try{
            return new ObjectMapper().writeValueAsString(new ErrorResponseDTO(type, msg));
        } catch (JsonProcessingException e) {
            return "{error:true}";
        }
    }
}
