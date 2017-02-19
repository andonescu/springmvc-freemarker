package ro.andonescu.demos.springmvcfreemarker.controllers.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ValidationError {
    private String message;
    private String field;
    private String code;
}
