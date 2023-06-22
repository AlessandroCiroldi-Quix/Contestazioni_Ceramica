package DTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class ErrorResponse {
    private boolean error;
    private String type;
    private String msg;

    public ErrorResponse(String type, String msg) {
        this.error = true;
        this.type = type;
        this.msg = msg;
    }

    @SuppressWarnings("unused")     // Suppress the warning
    public static String getError(String type, String msg) {
        try{
            return new ObjectMapper().writeValueAsString(new ErrorResponse(type, msg));
        } catch (JsonProcessingException e) {
            return "{error:true}";
        }
    }
}
