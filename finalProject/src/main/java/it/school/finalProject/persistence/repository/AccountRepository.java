package it.school.finalProject.persistence.repository;

import it.school.finalProject.persistence.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> getAccountsByCurrency(String currency);
}

