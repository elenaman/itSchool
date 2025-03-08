package it.school.finalProject.validator;

import it.school.finalProject.dto.TransactionDto;
import it.school.finalProject.exception.InvalidPayloadException;
import org.springframework.stereotype.Component;

@Component
public class TransactionValidator {

    public void validate(TransactionDto transactionDto) {
        if (transactionDto == null) {
            throw new InvalidPayloadException("Transaction data cannot be null.");
        }

        if (transactionDto.getAmount() == 0) {
            throw new InvalidPayloadException("Transaction amount cannot be zero.");
        }

        if (!transactionDto.getTransactionType().equalsIgnoreCase("DEPOSIT") &&
                !transactionDto.getTransactionType().equalsIgnoreCase("WITHDRAWAL")) {
            throw new InvalidPayloadException("Transaction type must be 'DEPOSIT' or 'WITHDRAWAL'.");
        }
    }
}
