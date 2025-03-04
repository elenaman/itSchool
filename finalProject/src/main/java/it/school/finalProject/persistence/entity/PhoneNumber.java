package it.school.finalProject.persistence.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneId;

    @ManyToOne
    @JoinColumn(name = "individual_id", nullable = false)
    private Individual individual;

    private String countryCode;
    private String phoneNumber;
    private String phoneType;
    private boolean isPrimary;
}

