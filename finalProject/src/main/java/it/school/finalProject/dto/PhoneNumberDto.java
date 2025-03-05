package it.school.finalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhoneNumberDto {
    private int phoneId;
    private int individualId;
    private String countryCode;
    private String phoneNumber;
    private String phoneType;
    private boolean isPrimary;
}