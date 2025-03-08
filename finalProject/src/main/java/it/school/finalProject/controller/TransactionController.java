package it.school.finalProject.controller;

import it.school.finalProject.dto.TransactionDto;
import it.school.finalProject.service.TransactionService;
import it.school.finalProject.validator.TransactionValidator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionValidator transactionValidator;

    public TransactionController(TransactionService transactionService, TransactionValidator transactionValidator) {
        this.transactionService = transactionService;
        this.transactionValidator = transactionValidator;
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable int id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        transactionValidator.validate(transactionDto);
        return ResponseEntity.ok(transactionService.createTransaction(transactionDto));
    }

    @PostMapping("/reverse/{transactionId}")
    public ResponseEntity<String> reverseTransaction(@PathVariable int transactionId) {
        transactionService.reverseTransaction(transactionId);
        return ResponseEntity.ok("Transaction reversed successfully.");
    }


}
