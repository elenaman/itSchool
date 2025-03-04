package it.school.finalProject.persistence.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}

