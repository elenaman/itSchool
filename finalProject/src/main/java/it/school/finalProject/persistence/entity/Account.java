package it.school.finalProject.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    private String accountNumber;
    private String iban;
    private String swift;
    private double balance;
    private String currency;
    private String accountType;

    @ManyToMany
    @JoinTable(
            name = "individual_account", // Join table name
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "accountId"), // Reference to Account
            inverseJoinColumns = @JoinColumn(name = "individual_id", referencedColumnName = "individualId") // Reference to Individual
    )
    private Set<Individual> individuals;
}
