package id.briliando.phonebookapi.core.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactQueryService {

    final private ContactRepository repository;

    @Autowired
    public ContactQueryService(ContactRepository repository) {
        this.repository = repository;
    }

    public List<Contact> findAllContact() {
        return repository.findAllContact();
    }
}
