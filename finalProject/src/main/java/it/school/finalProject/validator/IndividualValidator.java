package it.school.finalProject.validator;

import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.exception.InvalidPayloadException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class IndividualValidator {

    public void validate(IndividualDto individualDto) {
        if (individualDto == null) {
            throw new InvalidPayloadException("Individual data cannot be null.");
        }

        if (!StringUtils.hasText(individualDto.getFirstName())) {
            throw new InvalidPayloadException("First name is required.");
        }

        if (!StringUtils.hasText(individualDto.getLastName())) {
            throw new InvalidPayloadException("Last name is required.");
        }

        if (individualDto.getAge() <= 0) {
            throw new InvalidPayloadException("Age must be a positive number.");
        }

        if (!StringUtils.hasText(individualDto.getDateJoined())) {
            throw new InvalidPayloadException("Date joined is required.");
        }

        if (individualDto.getIdentificationDocument() != null) {
            validateIdentificationDocument(individualDto.getIdentificationDocument());
        }
    }

    private void validateIdentificationDocument(IndividualDto.IdentificationDocumentDto idDocument) {
        if (!StringUtils.hasText(idDocument.getIdSeries())) {
            throw new InvalidPayloadException("Identification document series is required.");
        }

        if (!StringUtils.hasText(idDocument.getIdNumber())) {
            throw new InvalidPayloadException("Identification document number is required.");
        }

        if (!StringUtils.hasText(idDocument.getIdType())) {
            throw new InvalidPayloadException("Identification document type is required.");
        }

        if (!StringUtils.hasText(idDocument.getIssueDate())) {
            throw new InvalidPayloadException("Identification document issue date is required.");
        }

        if (!StringUtils.hasText(idDocument.getExpirationDate())) {
            throw new InvalidPayloadException("Identification document expiration date is required.");
        }
    }
}
