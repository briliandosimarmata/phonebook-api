package id.briliando.phonebookapi.app.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import id.briliando.phonebookapi.core.contact.Contact;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Base64;

@JsonInclude
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ContactResponseDto {
    private String id;
    private String name;
    private String phoneNumber;
    private String avatar;
    private Long version;

    static ContactResponseDto fromDomain(Contact contact) {
        ContactResponseDto dto = new ContactResponseDto();
        dto.setId(contact.getId());
        dto.setName(contact.getName());
        dto.setPhoneNumber(contact.getPhoneNumber());
        dto.setAvatar(Base64.getEncoder().encodeToString(contact.getAvatar()));
        dto.setVersion(contact.getVersion());

        return dto;
    }
}
