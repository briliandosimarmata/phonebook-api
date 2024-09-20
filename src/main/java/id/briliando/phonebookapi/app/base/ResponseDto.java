package id.briliando.phonebookapi.app.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * membuat bentuk response api jadi seragam semua sesuai common convention
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
public class ResponseDto {

    private Object data;
    private Message message;

    public static ResponseDto data(Object data) {
        ResponseDto dto = new ResponseDto();
        dto.setData(data);

        return dto;
    }

    public static ResponseDto error(Message message) {
        ResponseDto dto = new ResponseDto();
        dto.setMessage(message);

        return dto;
    }

}
