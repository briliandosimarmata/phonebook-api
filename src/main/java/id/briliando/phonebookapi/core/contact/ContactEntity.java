package id.briliando.phonebookapi.core.contact;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Getter
@Setter
public class ContactEntity {
    @Id
    private String id;

    private String name;
    private String phoneNumber;
    private byte[] avatar;

    @Version
    private Long version;
}
