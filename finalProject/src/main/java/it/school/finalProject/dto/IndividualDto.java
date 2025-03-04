package it.school.finalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IndividualDto {
    private int individualId;

    private String firstName;
    private String lastName;
    private int age;
    private boolean isMemberActive;
    private String dateJoined;
    private IdentificationDocumentDto identificationDocument;
    private AddressDto address;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class IdentificationDocumentDto {
        private String idSeries;
        private String idNumber;
        private String idType;
        private String issueDate;
        private String expirationDate;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class AddressDto {
        private String country;
        private String city;
        private String zipCode;
        private String addressLine1;
        private String addressLine2;
        private String addressType;
    }

//    public static class PhoneNumberDto {
//        private int phoneId;
//        private String countryCode;
//        private String phoneNumber;
//        private String phoneType;
//        private boolean isPrimary;
//    }


}
