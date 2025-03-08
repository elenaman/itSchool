package it.school.finalProject.service;

import it.school.finalProject.dto.TransactionDto;
import it.school.finalProject.exception.ResourceNotFoundException;
import it.school.finalProject.mapper.TransactionMapper;
import it.school.finalProject.persistence.entity.Account;
import it.school.finalProject.persistence.entity.Transaction;
import it.school.finalProject.persistence.repository.AccountRepository;
import it.school.finalProject.persistence.repository.TransactionRepository;
import it.school.finalProject.validator.TransactionValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final TransactionMapper transactionMapper;
    private final TransactionValidator transactionValidator;

    public TransactionService(TransactionRepository transactionRepository,
                              AccountRepository accountRepository,
                              TransactionMapper transactionMapper,
                              TransactionValidator transactionValidator) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.transactionMapper = transactionMapper;
        this.transactionValidator = transactionValidator;
    }

    public List<TransactionDto> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(transactionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public TransactionDto getTransactionById(int id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));
        return transactionMapper.mapToDto(transaction);
    }

    @Transactional
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        transactionValidator.validate(transactionDto); // Validate before processing

        Account account = accountRepository.findById(transactionDto.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Transaction transaction = transactionMapper.mapToEntity(transactionDto);

        if ("DEPOSIT".equalsIgnoreCase(transaction.getTransactionType())) {
            account.setBalance(account.getBalance() + transaction.getAmount());
        } else if ("WITHDRAWAL".equalsIgnoreCase(transaction.getTransactionType())) {
            if (account.getBalance() < transaction.getAmount()) {
                throw new RuntimeException("Insufficient balance for withdrawal.");
            }
            account.setBalance(account.getBalance() - transaction.getAmount());
        } else {
            throw new RuntimeException("Invalid transaction type. Only DEPOSIT or WITHDRAWAL allowed.");
        }

        accountRepository.save(account);
        Transaction savedTransaction = transactionRepository.save(transaction);

        return transactionMapper.mapToDto(savedTransaction);
    }

    @Transactional
    public void reverseTransaction(int transactionId) {
        Transaction originalTransaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        Account account = originalTransaction.getAccount();
        if (account == null) {
            throw new RuntimeException("Account not associated with this transaction.");
        }

        Transaction reversedTransaction = new Transaction();
        reversedTransaction.setAccount(account);
        reversedTransaction.setAmount(originalTransaction.getAmount());
        reversedTransaction.setTransactionDate(LocalDateTime.now());
        reversedTransaction.setTransactionType(
                originalTransaction.getTransactionType().equalsIgnoreCase("DEPOSIT") ? "WITHDRAWAL" : "DEPOSIT"
        );
        reversedTransaction.setDescription("Reversal of transaction ID " + transactionId);
        if ("DEPOSIT".equalsIgnoreCase(originalTransaction.getTransactionType())) {
            if (account.getBalance() < originalTransaction.getAmount()) {
                throw new RuntimeException("Cannot reverse deposit as it would cause a negative balance.");
            }
            account.setBalance(account.getBalance() - originalTransaction.getAmount());
        } else if ("WITHDRAWAL".equalsIgnoreCase(originalTransaction.getTransactionType())) {
            account.setBalance(account.getBalance() + originalTransaction.getAmount());
        }

        accountRepository.save(account);
        transactionRepository.save(reversedTransaction);


    }
}
