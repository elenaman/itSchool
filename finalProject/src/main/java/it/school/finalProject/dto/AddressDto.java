package it.school.finalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDto {
    private int addressId;
    private int individualId;
    private String country;
    private String city;
    private String zipCode;
    private String addressLine1;
    private String addressLine2;
    private String addressType;
}
