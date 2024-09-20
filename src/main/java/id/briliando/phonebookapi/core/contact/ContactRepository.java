package id.briliando.phonebookapi.core.contact;

import java.util.List;

public interface ContactRepository {

    Contact addContact(Contact contact);

    Contact editContact(Contact contact);

    void deleteContact(Contact contact);

    Contact findContactById(String id);

    List<Contact> findAllContact();
}
