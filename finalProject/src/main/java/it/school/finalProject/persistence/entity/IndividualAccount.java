package it.school.finalProject.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class IndividualAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "individual_id", nullable = false)
    private Individual individual;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    private String ownershipType;
    private String linkedSince;
}

