package it.school.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {
    private int fromAccountId;
    private int toAccountId;
    private double amount;
}
