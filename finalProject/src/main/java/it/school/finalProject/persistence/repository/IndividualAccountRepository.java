package it.school.finalProject.persistence.repository;

import it.school.finalProject.persistence.entity.IndividualAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IndividualAccountRepository extends JpaRepository<IndividualAccount, Integer> {

    // Get accounts linked to an individual
    List<IndividualAccount> getIndividualAccountsByIndividual_IndividualId(int individualId);

    // JPQL: Get account ownerships by type
    @Query("SELECT ia FROM IndividualAccount ia WHERE ia.ownershipType = ?1")
    List<IndividualAccount> findAccountsByOwnershipTypeJpql(String ownershipType);

    // Native SQL: Get account ownerships by type
    @Query(value = "SELECT * FROM individual_account WHERE ownership_type = ?1", nativeQuery = true)
    List<IndividualAccount> findAccountsByOwnershipTypeNative(String ownershipType);
}

