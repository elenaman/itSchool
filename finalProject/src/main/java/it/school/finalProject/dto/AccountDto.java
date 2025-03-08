package it.school.finalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class AccountDto {
    private int accountId;
    private String accountNumber;
    private String iban;
    private String swift;
    private double balance;
    private String currency;
    private String accountType;
    private Set<Integer> individualIds;
}
