package id.briliando.phonebookapi.app.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import id.briliando.phonebookapi.core.contact.Contact;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Base64;

@JsonInclude
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ContactRequestDto {
    private String id;
    private String name;
    private String phoneNumber;
    private String avatar;
    private Long version;

    Contact toDomain() {
        return new Contact(this.id, this.name, this.phoneNumber,
                Base64.getDecoder().decode(this.avatar), this.version);
    }
}
