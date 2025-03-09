package it.school.finalProject.controller;


import it.school.finalProject.dto.TransactionDto;
import it.school.finalProject.service.TransactionService;
import it.school.finalProject.validator.TransactionValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TransactionControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TransactionService transactionService;

    @MockitoBean
    private TransactionValidator transactionValidator;

    @Test
    void testGetAllTransactions() throws Exception {
        TransactionDto transaction = new TransactionDto(1, 1, 200.0, "DEPOSIT",
                LocalDateTime.of(2024, 3, 8, 10, 0), "Deposit for savings");

        when(transactionService.getAllTransactions()).thenReturn(List.of(transaction));

        mockMvc.perform(get("/api/transactions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].transactionId").value(1))
                .andExpect(jsonPath("$[0].accountId").value(1))
                .andExpect(jsonPath("$[0].amount").value(200.0))
                .andExpect(jsonPath("$[0].transactionType").value("DEPOSIT"))
                .andExpect(jsonPath("$[0].description").value("Deposit for savings"));
    }

    @Test
    void testGetTransactionById() throws Exception {
        TransactionDto transaction = new TransactionDto(1, 1, 300.0, "WITHDRAWAL",
                LocalDateTime.of(2024, 3, 8, 12, 0), "ATM cash withdrawal");

        when(transactionService.getTransactionById(1)).thenReturn(transaction);

        mockMvc.perform(get("/api/transactions/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value(1))
                .andExpect(jsonPath("$.accountId").value(1))
                .andExpect(jsonPath("$.amount").value(300.0))
                .andExpect(jsonPath("$.transactionType").value("WITHDRAWAL"))
                .andExpect(jsonPath("$.description").value("ATM cash withdrawal"));
    }

    @Test
    void testCreateTransaction() throws Exception {
        TransactionDto newTransaction = new TransactionDto(1, 2, 500.0, "DEPOSIT",
                LocalDateTime.of(2024, 3, 8, 14, 0), "Salary deposit");

        when(transactionService.createTransaction(any(TransactionDto.class))).thenReturn(newTransaction);

        mockMvc.perform(
                        post("/api/transactions")
                                .contentType("application/json")
                                .content("""
                                        {
                                            "accountId": 2,
                                            "amount": 500.0,
                                            "transactionType": "DEPOSIT",
                                            "transactionDate": "2024-03-08T14:00:00",
                                            "description": "Salary deposit"
                                        }
                                        """)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value(1))
                .andExpect(jsonPath("$.accountId").value(2))
                .andExpect(jsonPath("$.amount").value(500.0))
                .andExpect(jsonPath("$.transactionType").value("DEPOSIT"))
                .andExpect(jsonPath("$.description").value("Salary deposit"));
    }

    @Test
    void testReverseTransaction() throws Exception {
        mockMvc.perform(post("/api/transactions/reverse/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Transaction reversed successfully."));
    }
}