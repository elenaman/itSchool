package it.school.finalProject.controller;

import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.service.IndividualService;
import it.school.finalProject.validator.IndividualValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

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
class IndividualControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IndividualService individualService;

    @MockitoBean
    private IndividualValidator individualValidator;

    @Test
    void testGetAllIndividuals() throws Exception {
        IndividualDto individual = new IndividualDto(1, "John", "Doe", 30, true, "2023-01-01", null);

        when(individualService.getAllIndividuals()).thenReturn(List.of(individual));

        mockMvc.perform(get("/api/individuals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].individualId").value(1))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[0].age").value(30))
                .andExpect(jsonPath("$[0].memberActive").value(true));
    }

    @Test
    void testGetIndividualById() throws Exception {
        IndividualDto individual = new IndividualDto(1, "John", "Doe", 30, true, "2023-01-01", null);

        when(individualService.getIndividualById(1)).thenReturn(individual);

        mockMvc.perform(get("/api/individuals/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.individualId").value(1))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.age").value(30));
    }

    @Test
    void testCreateIndividual() throws Exception {
        when(individualService.createIndividual(any(IndividualDto.class)))
                .thenReturn(new IndividualDto(1, "John", "Doe", 30, true, "2023-01-01", null));

        mockMvc.perform(
                        post("/api/individuals")
                                .contentType("application/json")
                                .content("""
                                        {
                                            "firstName": "John",
                                            "lastName": "Doe",
                                            "age": 30,
                                            "isMemberActive": true,
                                            "dateJoined": "2023-01-01"
                                        }
                                        """)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.individualId").value(1))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.age").value(30));
    }

    @Test
    void testUpdateIndividual() throws Exception {
        IndividualDto updatedIndividual = new IndividualDto(1, "John", "Smith", 32, true, "2023-01-01", null);

        when(individualService.updateIndividual(anyInt(), any(IndividualDto.class))).thenReturn(updatedIndividual);

        mockMvc.perform(
                        put("/api/individuals/1")
                                .contentType("application/json")
                                .content("""
                                    {
                                        "firstName": "John",
                                        "lastName": "Smith",
                                        "age": 32,
                                        "isMemberActive": true,
                                        "dateJoined": "2023-01-01"
                                    }
                                    """)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.individualId").value(1))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Smith"))
                .andExpect(jsonPath("$.age").value(32));
    }


    @Test
    void testDeleteIndividual() throws Exception {
        mockMvc.perform(delete("/api/individuals/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Individual deleted successfully."));
    }

    @Test
    void testGetActiveIndividualsOverAYear() throws Exception {
        IndividualDto individual = new IndividualDto(1, "John", "Doe", 30, true, "2023-01-01", null);

        when(individualService.getActiveIndividualsOverAYear()).thenReturn(List.of(individual));

        mockMvc.perform(get("/api/individuals/active-over-a-year"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].firstName").value("John"));
    }

    @Test
    void testGetIndividualsWithoutAccounts() throws Exception {
        IndividualDto individual = new IndividualDto(1, "Jane", "Doe", 28, false, "2022-05-15", null);

        when(individualService.getIndividualsWithoutAccounts()).thenReturn(List.of(individual));

        mockMvc.perform(get("/api/individuals/without-accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].firstName").value("Jane"));
    }

    @Test
    void testSearchIndividualsByName() throws Exception {
        IndividualDto individual = new IndividualDto(1, "Jane", "Doe", 28, false, "2022-05-15", null);

        when(individualService.searchIndividualsByName("Jane")).thenReturn(List.of(individual));

        mockMvc.perform(get("/api/individuals/search?name=Jane"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].firstName").value("Jane"));
    }

    @Test
    void testCheckLoanEligibility() throws Exception {
        when(individualService.checkLoanEligibility(1)).thenReturn(true);

        mockMvc.perform(get("/api/individuals/1/loan-eligibility"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }

    @Test
    void testGetIndividualsWithMultipleAddresses() throws Exception {
        IndividualDto individual = new IndividualDto(1, "Mark", "Doe", 35, true, "2020-07-10", null);

        when(individualService.getIndividualsWithMultipleAddresses()).thenReturn(List.of(individual));

        mockMvc.perform(get("/api/individuals/multiple-addresses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].firstName").value("Mark"));
    }
}