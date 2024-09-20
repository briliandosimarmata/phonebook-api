package id.briliando.phonebookapi.core.base;

import id.briliando.phonebookapi.infra.security.AuthUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter
public class BaseEntity {

    @Id
    @Setter
    private String id;
    @Version
    @Setter
    private Long version;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdBy = AuthUser.getUserId();
        this.createdDate = new Date();
        this.modifiedBy = AuthUser.getUserId();
        this.modifiedDate = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        this.modifiedBy = AuthUser.getUserId();
        this.modifiedDate = new Date();
    }
}
