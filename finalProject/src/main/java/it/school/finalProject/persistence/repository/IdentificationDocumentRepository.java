package it.school.finalProject.persistence.repository;

import it.school.finalProject.persistence.entity.IdentificationDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentificationDocumentRepository extends JpaRepository<IdentificationDocument, Integer> {
    List<IdentificationDocument> getIdentificationDocumentsByIdNumber(String idNumber);
}
