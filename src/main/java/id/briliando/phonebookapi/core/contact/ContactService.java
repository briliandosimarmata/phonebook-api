package id.briliando.phonebookapi.core.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {

    final private ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Contact addContact(Contact contact) {
        valContactData(contact);
        return repository.addContact(contact);
    }

    @Transactional
    public Contact editContact(Contact contact) {
        valContactData(contact);
        return repository.editContact(contact);
    }

    @Transactional
    public void deleteContact(Contact contact) {
        repository.deleteContact(contact);
    }

    public Contact findContactById(String id) {
        return repository.findContactById(id);
    }

    private void valContactData(Contact contact) {
        contact.valNameMaxLength();
        contact.valPhoneNumberMaxLength();
        contact.valPhoneNumberOnlyContainsNumeric();
        contact.valAvatarMaxLength();
    }
}
