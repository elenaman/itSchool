package it.school.finalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDto {
    private int transactionId;
    private int accountId;
    private double amount;
    private String transactionType;
    private LocalDateTime transactionDate;
    private String description;
}
