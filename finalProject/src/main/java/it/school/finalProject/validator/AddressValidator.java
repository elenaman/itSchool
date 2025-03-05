package it.school.finalProject.validator;


import it.school.finalProject.dto.AddressDto;
import it.school.finalProject.exception.InvalidPayloadException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class AddressValidator {

    public void validate(AddressDto addressDto) {
        if (addressDto.getIndividualId() <= 0) {
            throw new InvalidPayloadException("Invalid individualId: must be greater than zero.");
        }

        if (!StringUtils.hasText(addressDto.getCountry())) {
            throw new InvalidPayloadException("Country is required.");
        }

        if (!StringUtils.hasText(addressDto.getCity())) {
            throw new InvalidPayloadException("City is required.");
        }

        if (!StringUtils.hasText(addressDto.getZipCode())) {
            throw new InvalidPayloadException("Zip Code is required.");
        }

        if (!addressDto.getZipCode().matches("\\d{5}")) {
            throw new InvalidPayloadException("Zip Code must be a 5-digit number.");
        }

        if (!StringUtils.hasText(addressDto.getAddressLine1())) {
            throw new InvalidPayloadException("Address Line 1 is required.");
        }

        if (!StringUtils.hasText(addressDto.getAddressType())) {
            throw new InvalidPayloadException("Address Type is required.");
        }

        if (!addressDto.getAddressType().matches("(?i)Home|Work|Other")) { // Allow "Home", "Work", "Other"
            throw new InvalidPayloadException("Invalid address type. Allowed values: Home, Work, Other.");
        }
    }
}

