package it.school.finalProject.persistence.repository;

import it.school.finalProject.persistence.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {
    List<PhoneNumber> getPhoneNumbersByCountryCode(String countryCode);
}

