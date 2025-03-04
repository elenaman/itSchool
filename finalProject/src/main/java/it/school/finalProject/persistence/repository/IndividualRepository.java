package it.school.finalProject.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.school.finalProject.persistence.entity.Individual;

import java.util.List;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Integer> {
    List<Individual> getIndividualsByFirstName(String firstName);

    @Query("SELECT i FROM Individual i WHERE i.firstName = ?1 AND i.lastName = ?2")
    List<Individual> findIndividualsByFirstAndLastNameJpql(String firstName, String lastName);

    @Query(value = "SELECT * FROM individuals WHERE first_name = ?1 AND last_name = ?2", nativeQuery = true)
    List<Individual> findIndividualsByFirstAndLastNameNative(String firstName, String lastName);

}
