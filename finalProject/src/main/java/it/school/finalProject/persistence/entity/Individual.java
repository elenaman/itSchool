package it.school.finalProject.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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



    public String getDateJoined(){
        return dateJoined;
    }

    public boolean isMemberActive(){
        return isMemberActive;
    }

    @JsonBackReference
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "individualDocumentId", referencedColumnName = "documentId")
    private IdentificationDocument identificationDocument;

    @JsonManagedReference
    @OneToMany(mappedBy = "individual")
    private List<Address> address;

    @JsonManagedReference
    @OneToMany
    private List<PhoneNumber> phoneNumber;


}
