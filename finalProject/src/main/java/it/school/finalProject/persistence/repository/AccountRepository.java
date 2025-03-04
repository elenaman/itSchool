package it.school.finalProject.persistence.repository;

import it.school.finalProject.persistence.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    // Get accounts by currency
    List<Account> getAccountsByCurrency(String currency);

    // JPQL: Get accounts by account type
    @Query("SELECT a FROM Account a WHERE a.accountType = ?1")
    List<Account> findAccountsByTypeJpql(String accountType);

    // Native SQL: Get accounts by account type
    @Query(value = "SELECT * FROM account WHERE account_type = ?1", nativeQuery = true)
    List<Account> findAccountsByTypeNative(String accountType);
}

