package pl.karpisiewicz.mateusz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.karpisiewicz.mateusz.entity.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAllByEmail(String email);
}
