package it.school.finalProject.mapper.impl;

import it.school.finalProject.dto.TransactionDto;
import it.school.finalProject.persistence.entity.Transaction;
import it.school.finalProject.persistence.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionDto mapToDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getTransactionId(),
                transaction.getAccount().getAccountId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getTransactionDate(),
                transaction.getDescription()
        );
    }

    public Transaction mapToEntity(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDto.getAmount());
        transaction.setTransactionType(transactionDto.getTransactionType());
        transaction.setTransactionDate(transactionDto.getTransactionDate());
        transaction.setDescription(transactionDto.getDescription());

        Account account = new Account();
        account.setAccountId(transactionDto.getAccountId());
        transaction.setAccount(account);

        return transaction;
    }
}
