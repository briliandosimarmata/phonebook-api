package id.briliando.phonebookapi.core.contact;

public interface ContactRepository {

    Contact addContact(Contact contact);

    Contact editContact(Contact contact);

    void deleteContact(Contact contact);

    Contact findContactById(String id);
}
