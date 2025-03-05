package it.school.finalProject.validator;

import it.school.finalProject.dto.PhoneNumberDto;
import it.school.finalProject.exception.InvalidPayloadException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PhoneNumberValidator {
    public void validate(PhoneNumberDto phoneNumberDto) {
        if (phoneNumberDto.getIndividualId() <= 0) {
            throw new InvalidPayloadException("Invalid individualId: must be greater than zero.");
        }

        if (!StringUtils.hasText(phoneNumberDto.getCountryCode())) {
            throw new InvalidPayloadException("Country code is required.");
        }

        if (!StringUtils.hasText(phoneNumberDto.getPhoneNumber())) {
            throw new InvalidPayloadException("Phone number is required.");
        }

        if (!phoneNumberDto.getPhoneNumber().matches("\\d{7,15}")) { // Supports numbers with 7 to 15 digits
            throw new InvalidPayloadException("Phone number must contain between 7 and 15 digits.");
        }

        if (!StringUtils.hasText(phoneNumberDto.getPhoneType())) {
            throw new InvalidPayloadException("Phone type is required.");
        }

        if (!phoneNumberDto.getPhoneType().matches("(?i)Mobile|Home|Work|Other")) { // Case-insensitive match
            throw new InvalidPayloadException("Invalid phone type. Allowed values: Mobile, Home, Work, Other.");
        }
    }

}
