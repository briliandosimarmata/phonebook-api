package id.briliando.phonebookapi.app.contact;

import id.briliando.phonebookapi.app.base.ResponseDto;
import id.briliando.phonebookapi.core.contact.Contact;
import id.briliando.phonebookapi.core.contact.ContactQueryService;
import id.briliando.phonebookapi.core.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    /**
     * notes: request dan response dto dibedakan, sesuai konsep single responsiblity
     * walau sekarang isinya sama,
     * siapa tau suatu saat ada informasi dari request yang perlu ditambah/dikurangi
     */

    private final ContactService service;
    private final ContactQueryService queryService;

    @Autowired
    public ContactController(ContactService service, ContactQueryService queryService) {
        this.service = service;
        this.queryService = queryService;
    }

    @GetMapping("/{id}")
    public ResponseDto findContactById(@PathVariable String id) {
        Contact contact = service.findContactById(id);

        return ResponseDto.data(ContactResponseDto.fromDomain(contact));
    }

    @PostMapping
    public ResponseDto addContact(@RequestBody ContactRequestDto requestDto) {
        Contact contact = service.addContact(requestDto.toDomain());

        return ResponseDto.data(ContactResponseDto.fromDomain(contact));
    }

    @PutMapping
    public ResponseDto editContact(@RequestBody ContactRequestDto requestDto) {
        Contact contact = service.editContact(requestDto.toDomain());

        return ResponseDto.data(ContactResponseDto.fromDomain(contact));
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable String id, @RequestParam Long version) {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setVersion(version);
        service.deleteContact(contact);
    }

    @GetMapping
    public ResponseDto findAllContact() {
        List<Contact> contacts = queryService.findAllContact();
        return ResponseDto.data(ContactResponseDto.fromDomains(contacts));
    }
}
