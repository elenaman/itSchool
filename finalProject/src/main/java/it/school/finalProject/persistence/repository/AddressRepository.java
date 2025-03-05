package it.school.finalProject.persistence.repository;

import it.school.finalProject.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> getAddressesByCity(String city);
}
