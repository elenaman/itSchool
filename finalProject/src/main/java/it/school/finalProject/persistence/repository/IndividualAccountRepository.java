package it.school.finalProject.persistence.repository;

import it.school.finalProject.persistence.entity.IndividualAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IndividualAccountRepository extends JpaRepository<IndividualAccount, Integer> {
    List<IndividualAccount> getIndividualAccountsByIndividual_IndividualId(int individualId);
}

