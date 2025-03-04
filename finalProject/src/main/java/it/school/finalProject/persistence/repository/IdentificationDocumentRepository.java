package it.school.finalProject.persistence.repository;

import it.school.finalProject.persistence.entity.IdentificationDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentificationDocumentRepository extends JpaRepository<IdentificationDocument, Integer> {

    // Get documents by ID number
    List<IdentificationDocument> getIdentificationDocumentsByIdNumber(String idNumber);

    // JPQL: Get documents by type
    @Query("SELECT d FROM IdentificationDocument d WHERE d.idType = ?1")
    List<IdentificationDocument> findDocumentsByTypeJpql(String idType);

    // Native SQL: Get documents by type
    @Query(value = "SELECT * FROM identification_document WHERE id_type = ?1", nativeQuery = true)
    List<IdentificationDocument> findDocumentsByTypeNative(String idType);
}
