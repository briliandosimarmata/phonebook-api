package id.briliando.phonebookapi.app.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import id.briliando.phonebookapi.core.contact.Contact;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

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

    static List<ContactResponseDto> fromDomains(List<Contact> contacts) {
        List<ContactResponseDto> dtos = new ArrayList<>();

        contacts.forEach(
                contact -> {
                    dtos.add(fromDomain(contact));
                }
        );

        return dtos;
    }
}
