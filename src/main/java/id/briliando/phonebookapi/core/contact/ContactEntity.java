package id.briliando.phonebookapi.core.contact;

import id.briliando.phonebookapi.infra.security.AuthUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

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

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
    }
}
