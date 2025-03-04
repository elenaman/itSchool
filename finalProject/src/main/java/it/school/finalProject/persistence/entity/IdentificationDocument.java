package it.school.finalProject.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class IdentificationDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    private String idSeries;
    private String idNumber;
    private String idType;
    private String issueDate;
    private String expirationDate;
}
