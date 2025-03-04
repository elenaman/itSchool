package it.school.finalProject.persistence.repository;

import it.school.finalProject.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    // Get addresses by city
    List<Address> getAddressesByCity(String city);

    // JPQL: Get addresses by country
    @Query("SELECT a FROM Address a WHERE a.country = ?1")
    List<Address> findAddressesByCountryJpql(String country);

    // Native SQL: Get addresses by country
    @Query(value = "SELECT * FROM address WHERE country = ?1", nativeQuery = true)
    List<Address> findAddressesByCountryNative(String country);
}
