package id.briliando.phonebookapi.core.contact;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Repository
public class ContactJPARepository extends SimpleJpaRepository<ContactEntity, String> implements ContactRepository {

    @Autowired
    public ContactJPARepository(EntityManager em) {
        super(ContactEntity.class, em);
    }

    @Override
    @Transactional
    public Contact addContact(Contact contact) {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setName(contact.getName());
        contactEntity.setPhoneNumber(contact.getPhoneNumber());
        contactEntity.setAvatar(contact.getAvatar());

        ContactEntity savedContactEntity = saveAndFlush(contactEntity);

        return new Contact(savedContactEntity.getId(), savedContactEntity.getName(),
                savedContactEntity.getPhoneNumber(), savedContactEntity.getAvatar(),
                savedContactEntity.getVersion());
    }

    @Override
    @Transactional
    public Contact editContact(Contact contact) {
        ContactEntity contactEntity = getReferenceById(contact.getId());
        contactEntity.setName(contact.getName());
        contactEntity.setPhoneNumber(contact.getPhoneNumber());
        contactEntity.setAvatar(contact.getAvatar());

        ContactEntity savedContactEntity = saveAndFlush(contactEntity);

        return new Contact(savedContactEntity.getId(), savedContactEntity.getName(),
                savedContactEntity.getPhoneNumber(), savedContactEntity.getAvatar(),
                savedContactEntity.getVersion());
    }

    @Override
    @Transactional
    public void deleteContact(Contact contact) {
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setId(contact.getId());
        contactEntity.setVersion(contact.getVersion());

        delete(contactEntity);
    }

    @Override
    public Contact findContactById(String id) {
        ContactEntity contactEntity = getReferenceById(id);

        return new Contact(contactEntity.getId(), contactEntity.getName(),
                contactEntity.getPhoneNumber(), contactEntity.getAvatar(),
                contactEntity.getVersion());
    }

    @Override
    public List<Contact> findAllContact() {
        List<Contact> contacts = new ArrayList<>();
        List<ContactEntity> contactEntities = findAll();

        contactEntities.forEach(
                contactEntity -> {
                    contacts.add(new Contact(contactEntity.getId(),
                            contactEntity.getName(), contactEntity.getPhoneNumber(),
                            contactEntity.getAvatar(), contactEntity.getVersion()));
                }
        );

        return contacts;
    }
}
