package ro.andonescu.demos.springmvcfreemarker.controllers.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
public class Response {
    private String message;
    private String code;
    private List<ValidationError> errors = new ArrayList<>();
}
