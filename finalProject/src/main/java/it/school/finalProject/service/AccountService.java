package it.school.finalProject.service;

import it.school.finalProject.dto.AccountDto;
import it.school.finalProject.exception.ResourceNotFoundException;
import it.school.finalProject.mapper.ObjectMapper;
import it.school.finalProject.persistence.entity.Account;
import it.school.finalProject.persistence.entity.Individual;
import it.school.finalProject.persistence.repository.AccountRepository;
import it.school.finalProject.persistence.repository.IndividualRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final IndividualRepository individualRepository;
    private final ObjectMapper<AccountDto, Account> accountMapper;

    public AccountService(AccountRepository accountRepository, IndividualRepository individualRepository, ObjectMapper<AccountDto, Account> accountMapper) {
        this.accountRepository = accountRepository;
        this.individualRepository = individualRepository;
        this.accountMapper = accountMapper;
    }

    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public AccountDto getAccountById(int id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));
        return accountMapper.mapToDto(account);
    }

    public AccountDto createAccount(AccountDto accountDto) {
        Account account = accountMapper.mapToEntity(accountDto);

        Set<Individual> individuals = accountDto.getIndividualIds().stream()
                .map(individualId -> individualRepository.findById(individualId)
                        .orElseThrow(() -> new ResourceNotFoundException("Individual not found with ID: " + individualId)))
                .collect(Collectors.toSet());

        account.setIndividuals(individuals);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.mapToDto(savedAccount);
    }

    public AccountDto updateAccount(int id, AccountDto accountDto) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));

        existingAccount.setAccountNumber(accountDto.getAccountNumber());
        existingAccount.setIban(accountDto.getIban());
        existingAccount.setSwift(accountDto.getSwift());
        existingAccount.setBalance(accountDto.getBalance());
        existingAccount.setCurrency(accountDto.getCurrency());
        existingAccount.setAccountType(accountDto.getAccountType());

        Set<Individual> individuals = accountDto.getIndividualIds().stream()
                .map(individualId -> individualRepository.findById(individualId)
                        .orElseThrow(() -> new ResourceNotFoundException("Individual not found with ID: " + individualId)))
                .collect(Collectors.toSet());

        existingAccount.setIndividuals(individuals);

        Account updatedAccount = accountRepository.save(existingAccount);
        return accountMapper.mapToDto(updatedAccount);
    }

    public void deleteAccount(int id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));
        accountRepository.delete(account);
    }

    public double getAccountBalance(int accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + accountId));
        return account.getBalance();
    }

    public List<AccountDto> getAccountsByIndividual(int individualId) {
        return accountRepository.findByIndividuals_IndividualId(individualId)
                .stream()
                .map(accountMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + fromAccountId));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + toAccountId));

        if (fromAccount.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds in account " + fromAccountId);
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
