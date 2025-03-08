package it.school.finalProject.mapper.impl;

import it.school.finalProject.dto.AccountDto;
import it.school.finalProject.mapper.ObjectMapper;
import it.school.finalProject.persistence.entity.Account;
import it.school.finalProject.persistence.entity.Individual;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AccountMapper implements ObjectMapper<AccountDto, Account> {

    @Override
    public AccountDto mapToDto(Account account) {
        return new AccountDto(
                account.getAccountId(),
                account.getAccountNumber(),
                account.getIban(),
                account.getSwift(),
                account.getBalance(),
                account.getCurrency(),
                account.getAccountType(),
                account.getIndividuals()
                        .stream()
                        .map(Individual::getIndividualId)
                        .collect(Collectors.toSet())
        );
    }

    @Override
    public Account mapToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setAccountId(accountDto.getAccountId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setIban(accountDto.getIban());
        account.setSwift(accountDto.getSwift());
        account.setBalance(accountDto.getBalance());
        account.setCurrency(accountDto.getCurrency());
        account.setAccountType(accountDto.getAccountType());

        Set<Individual> individuals = accountDto.getIndividualIds().stream()
                .map(id -> {
                    Individual individual = new Individual();
                    individual.setIndividualId(id);
                    return individual;
                })
                .collect(Collectors.toSet());

        account.setIndividuals(individuals);
        return account;
    }
}
