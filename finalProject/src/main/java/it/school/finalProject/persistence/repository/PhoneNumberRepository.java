package it.school.finalProject.persistence.repository;

import it.school.finalProject.persistence.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

    // Get phone numbers by country code
    List<PhoneNumber> getPhoneNumbersByCountryCode(String countryCode);

    // JPQL: Get phone numbers by type
    @Query("SELECT p FROM PhoneNumber p WHERE p.phoneType = ?1")
    List<PhoneNumber> findPhoneNumbersByTypeJpql(String phoneType);

    // Native SQL: Get phone numbers by type
    @Query(value = "SELECT * FROM phone_number WHERE phone_type = ?1", nativeQuery = true)
    List<PhoneNumber> findPhoneNumbersByTypeNative(String phoneType);
}

