package it.school.finalProject.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.util.List;

@Entity
@Getter
@Setter
public class Individual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int individualId;

    private String firstName;
    private String lastName;
    private int age;
    private boolean isMemberActive;
    private String dateJoined;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "individualDocumentId", referencedColumnName = "documentId")
    private IdentificationDocument identificationDocument;

    @OneToMany(mappedBy = "individual")
    private List<Address> address;

    @OneToMany(mappedBy = "individual")
    private List<PhoneNumber> phoneNumber;

    @ManyToMany(mappedBy = "individuals") // No @JoinTable here!
    private Set<Account> accounts;
}
