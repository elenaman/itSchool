package it.school.finalProject.validator;

import it.school.finalProject.dto.AccountDto;
import it.school.finalProject.exception.InvalidPayloadException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Set;

@Component
public class AccountValidator {

    public void validate(AccountDto accountDto) {
        if (!StringUtils.hasText(accountDto.getAccountNumber())) {
            throw new InvalidPayloadException("Account number is required.");
        }

        if (!StringUtils.hasText(accountDto.getIban())) {
            throw new InvalidPayloadException("IBAN is required.");
        }

        if (!accountDto.getIban().matches("[A-Z]{2}\\d{20}")) { // Example IBAN format (adjust for different countries)
            throw new InvalidPayloadException("IBAN must be in the format: 2 letters followed by 20 digits.");
        }

        if (!StringUtils.hasText(accountDto.getSwift())) {
            throw new InvalidPayloadException("SWIFT code is required.");
        }

        if (!accountDto.getSwift().matches("[A-Z0-9]{8,11}")) { // Standard SWIFT code format
            throw new InvalidPayloadException("SWIFT code must be 8 or 11 alphanumeric characters.");
        }

        if (accountDto.getBalance() < 0) {
            throw new InvalidPayloadException("Balance cannot be negative.");
        }

        if (!StringUtils.hasText(accountDto.getCurrency())) {
            throw new InvalidPayloadException("Currency is required.");
        }

        if (!accountDto.getCurrency().matches("[A-Z]{3}")) { // Standard 3-letter currency codes (e.g., USD, EUR)
            throw new InvalidPayloadException("Currency must be a valid 3-letter code (e.g., USD, EUR).");
        }

        if (!StringUtils.hasText(accountDto.getAccountType())) {
            throw new InvalidPayloadException("Account type is required.");
        }

        if (!accountDto.getAccountType().matches("(?i)Savings|Checking|Business|Other")) {
            throw new InvalidPayloadException("Invalid account type. Allowed values: Savings, Checking, Business, Other.");
        }

        if (accountDto.getIndividualIds() == null || accountDto.getIndividualIds().isEmpty()) {
            throw new InvalidPayloadException("At least one individual must be associated with the account.");
        }

        for (Integer id : accountDto.getIndividualIds()) {
            if (id <= 0) {
                throw new InvalidPayloadException("Invalid individual ID: must be greater than zero.");
            }
        }
    }
}
