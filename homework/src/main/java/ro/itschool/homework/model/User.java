package ro.itschool.homework.model;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int SSN;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSSN() {
        return SSN;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }
}
