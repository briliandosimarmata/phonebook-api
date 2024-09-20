package id.briliando.phonebookapi.app.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
public class Message {
    private String code;
    private String message;

    public Message(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
