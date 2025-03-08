package it.school.finalProject.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.school.finalProject.persistence.entity.Individual;

import java.util.List;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Integer> {
    List<Individual> getIndividualsByFirstName(String firstName);

    List<Individual> findByDateJoinedBefore(String date);

    List<Individual> findByAccountsIsEmpty();

    List<Individual> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

    @Query("SELECT i FROM Individual i WHERE SIZE(i.address) > 1")
    List<Individual> findIndividualsWithMultipleAddresses();
}


