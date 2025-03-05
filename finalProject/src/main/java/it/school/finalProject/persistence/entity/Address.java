package it.school.finalProject.persistence.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;


    @ManyToOne
    @JoinColumn(name = "individualId", referencedColumnName = "individualId")
    private Individual individual;

    private String country;
    private String city;
    private String zipCode;
    private String addressLine1;
    private String addressLine2;
    private String addressType;
}
