package it.school.finalProject.controller;

import it.school.finalProject.dto.AccountDto;
import it.school.finalProject.service.AccountService;
import it.school.finalProject.validator.AccountValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountValidator accountValidator;

    public AccountController(AccountService accountService, AccountValidator accountValidator) {
        this.accountService = accountService;
        this.accountValidator = accountValidator;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable int id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        accountValidator.validate(accountDto);
        return ResponseEntity.ok(accountService.createAccount(accountDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable int id, @RequestBody AccountDto accountDto) {
        accountValidator.validate(accountDto);
        return ResponseEntity.ok(accountService.updateAccount(id, accountDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully.");
    }
}
