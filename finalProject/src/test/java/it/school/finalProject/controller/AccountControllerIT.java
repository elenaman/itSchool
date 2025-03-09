package it.school.finalProject.controller;

import it.school.finalProject.dto.AccountDto;
import it.school.finalProject.dto.TransferRequest;
import it.school.finalProject.service.AccountService;
import it.school.finalProject.validator.AccountValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AccountService accountService;

    @MockitoBean
    private AccountValidator accountValidator;

    @Test
    void testGetAllAccounts() throws Exception {
        AccountDto account = new AccountDto(1, "123456", "IBAN123", "SWIFT123", 500.0, "USD", "SAVINGS", Set.of(1, 2));

        when(accountService.getAllAccounts()).thenReturn(List.of(account));

        mockMvc.perform(get("/api/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].accountId").value(1))
                .andExpect(jsonPath("$[0].accountNumber").value("123456"))
                .andExpect(jsonPath("$[0].iban").value("IBAN123"))
                .andExpect(jsonPath("$[0].swift").value("SWIFT123"))
                .andExpect(jsonPath("$[0].balance").value(500.0))
                .andExpect(jsonPath("$[0].currency").value("USD"))
                .andExpect(jsonPath("$[0].accountType").value("SAVINGS"));
    }

    @Test
    void testGetAccountById() throws Exception {
        AccountDto account = new AccountDto(1, "123456", "IBAN123", "SWIFT123", 500.0, "USD", "SAVINGS", Set.of(1, 2));

        when(accountService.getAccountById(1)).thenReturn(account);

        mockMvc.perform(get("/api/accounts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountId").value(1))
                .andExpect(jsonPath("$.accountNumber").value("123456"));
    }

    @Test
    void testCreateAccount() throws Exception {
        AccountDto mockAccount = new AccountDto(1, "123456", "IBAN123", "SWIFT123", 500.0, "USD", "SAVINGS", Set.of());

        when(accountService.createAccount(any(AccountDto.class))).thenReturn(mockAccount);

        mockMvc.perform(
                        post("/api/accounts")
                                .contentType("application/json")
                                .content("""
                            {
                                "accountNumber": "123456",
                                "iban": "IBAN123",
                                "swift": "SWIFT123",
                                "balance": 500.0,
                                "currency": "USD",
                                "accountType": "SAVINGS"
                            }
                            """)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountId").value(1))
                .andExpect(jsonPath("$.accountNumber").value("123456"))
                .andExpect(jsonPath("$.iban").value("IBAN123"))
                .andExpect(jsonPath("$.swift").value("SWIFT123"))
                .andExpect(jsonPath("$.balance").value(500.0))
                .andExpect(jsonPath("$.currency").value("USD"))
                .andExpect(jsonPath("$.accountType").value("SAVINGS"));
    }

    @Test
    void testUpdateAccount() throws Exception {
        AccountDto updatedAccount = new AccountDto(1, "654321", "IBAN654", "SWIFT654", 700.0, "EUR", "CURRENT", Set.of(2, 1));

        when(accountService.updateAccount(anyInt(), any(AccountDto.class))).thenReturn(updatedAccount);

        mockMvc.perform(
                        put("/api/accounts/1")
                                .contentType("application/json")
                                .content("""
                            {
                                "accountNumber": "654321",
                                "iban": "IBAN654",
                                "swift": "SWIFT654",
                                "balance": 700.0,
                                "currency": "EUR",
                                "accountType": "CURRENT"
                            }
                            """)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountId").value(1))
                .andExpect(jsonPath("$.accountNumber").value("654321"))
                .andExpect(jsonPath("$.iban").value("IBAN654"))
                .andExpect(jsonPath("$.swift").value("SWIFT654"))
                .andExpect(jsonPath("$.balance").value(700.0))
                .andExpect(jsonPath("$.currency").value("EUR"))
                .andExpect(jsonPath("$.accountType").value("CURRENT"));
    }


    @Test
    void testDeleteAccount() throws Exception {
        mockMvc.perform(delete("/api/accounts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Account deleted successfully."));
    }

    @Test
    void testGetAccountBalance() throws Exception {
        when(accountService.getAccountBalance(1)).thenReturn(500.0);

        mockMvc.perform(get("/api/accounts/1/balance"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(500.0));
    }

    @Test
    void testGetAccountsByIndividual() throws Exception {
        AccountDto account = new AccountDto(1, "123456", "IBAN123", "SWIFT123", 500.0, "USD", "SAVINGS", Set.of(1, 2));
        when(accountService.getAccountsByIndividual(1)).thenReturn(List.of(account));

        mockMvc.perform(get("/api/accounts/by-individual/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].accountId").value(1));
    }

    @Test
    void testTransferMoney() throws Exception {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setFromAccountId(1);
        transferRequest.setToAccountId(2);
        transferRequest.setAmount(100.0);

        doNothing().when(accountService).transferMoney(anyInt(), anyInt(), anyDouble());

        mockMvc.perform(
                        post("/api/accounts/transfer")
                                .contentType("application/json")
                                .content("""
                            {
                                "fromAccountId": 1,
                                "toAccountId": 2,
                                "amount": 100.0
                            }
                            """)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Transfer successful."));
    }
}