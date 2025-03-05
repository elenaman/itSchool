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

}
