package id.briliando.phonebookapi.app.base;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Message {
    private String code;
    private String message;
}
