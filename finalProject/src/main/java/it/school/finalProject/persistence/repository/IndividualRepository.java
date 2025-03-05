package it.school.finalProject.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.school.finalProject.persistence.entity.Individual;

import java.util.List;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Integer> {
    List<Individual> getIndividualsByFirstName(String firstName);
}
