package pl.karpisiewicz.mateusz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.karpisiewicz.mateusz.entity.Contact;
import pl.karpisiewicz.mateusz.repository.ContactRepository;
import pl.karpisiewicz.mateusz.service.ContactService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @PostConstruct
    public void init() {
        Contact contact = new Contact();
        contact.setLastName("Karpisiewicz");
        contact.setFirstName("Mateusz");
        contact.setMiddleNameInitial("G");
        contact.setEmail("mateusz.karpisiewicz@gmail.com");
        createContact(contact);

        getContactsByEmail("mateusz.karpisiewicz@gmail.com").stream().forEach(c -> System.out.println(c.getFirstName()));
        System.out.println(getContact(1L).getId());
    }

    @Override
    public void createContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getContactsByEmail(String email) {
        return contactRepository.findAllByEmail(email);
    }

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public void updateContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.delete(id);
    }
}
