package it.school.finalProject.controller;

import it.school.finalProject.dto.AddressDto;
import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.service.AddressService;
import it.school.finalProject.service.IndividualService;
import it.school.finalProject.validator.AddressValidator;
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
class AddressControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AddressService addressService;

    @MockitoBean
    private IndividualService individualService;

    @MockitoBean
    private AddressValidator addressValidator;

    @Test
    void testGetAllAddresses() throws Exception {
        AddressDto address = new AddressDto(1, 1, "USA", "New York", "10001", "123 Main St", "Apt 2", "HOME");

        when(addressService.getAllAddresses()).thenReturn(List.of(address));

        mockMvc.perform(get("/api/addresses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].addressId").value(1))
                .andExpect(jsonPath("$[0].addressLine1").value("123 Main St"))
                .andExpect(jsonPath("$[0].city").value("New York"))
                .andExpect(jsonPath("$[0].country").value("USA"));
    }

    @Test
    void testGetAddressById() throws Exception {
        AddressDto address = new AddressDto(1, 1, "USA", "New York", "10001", "123 Main St", "Apt 2", "HOME");

        when(addressService.getAddressById(1)).thenReturn(address);

        mockMvc.perform(get("/api/addresses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.addressId").value(1))
                .andExpect(jsonPath("$.addressLine1").value("123 Main St"))
                .andExpect(jsonPath("$.city").value("New York"))
                .andExpect(jsonPath("$.country").value("USA"));
    }

    @Test
    void testCreateAddress() throws Exception {
        AddressDto newAddress = new AddressDto(1, 2, "USA", "Los Angeles", "90001", "456 Elm St", "Apt 5", "WORK");

        when(addressService.createAddress(any(AddressDto.class))).thenReturn(newAddress);

        mockMvc.perform(
                        post("/api/addresses")
                                .contentType("application/json")
                                .content("""
                                        {
                                            "addressLine1": "456 Elm St",
                                            "addressLine2": "Apt 5",
                                            "addressType": "WORK",
                                            "city": "Los Angeles",
                                            "country": "USA",
                                            "zipCode": "90001",
                                            "individualId": 2
                                        }
                                        """)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.addressId").value(1))
                .andExpect(jsonPath("$.addressLine1").value("456 Elm St"))
                .andExpect(jsonPath("$.city").value("Los Angeles"))
                .andExpect(jsonPath("$.country").value("USA"));
    }

    @Test
    void testUpdateAddress() throws Exception {
        AddressDto updatedAddress = new AddressDto(1, 3, "USA", "San Francisco", "94102", "789 Oak St", "Suite 100", "HOME");

        when(addressService.updateAddress(anyInt(), any(AddressDto.class))).thenReturn(updatedAddress);

        mockMvc.perform(
                        put("/api/addresses/1")
                                .contentType("application/json")
                                .content("""
                                        {
                                            "addressLine1": "789 Oak St",
                                            "addressLine2": "Suite 100",
                                            "addressType": "HOME",
                                            "city": "San Francisco",
                                            "country": "USA",
                                            "zipCode": "94102",
                                            "individualId": 3
                                        }
                                        """)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.addressId").value(1))
                .andExpect(jsonPath("$.addressLine1").value("789 Oak St"))
                .andExpect(jsonPath("$.city").value("San Francisco"))
                .andExpect(jsonPath("$.country").value("USA"));
    }

    @Test
    void testDeleteAddress() throws Exception {
        mockMvc.perform(delete("/api/addresses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Address deleted successfully."));
    }

    @Test
    void testGetAddressesByIndividual() throws Exception {
        AddressDto address = new AddressDto(1, 1, "USA", "New York", "10001", "123 Main St", "Apt 2", "HOME");

        when(addressService.getAddressesByIndividual(1)).thenReturn(List.of(address));

        mockMvc.perform(get("/api/addresses/by-individual/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].addressLine1").value("123 Main St"));
    }

    @Test
    void testGetIndividualsByCity() throws Exception {
        IndividualDto individual = new IndividualDto(1, "John", "Doe", 30, true, "2023-01-01", null);

        when(addressService.getIndividualsByCity("New York")).thenReturn(List.of(individual));

        mockMvc.perform(get("/api/addresses/by-city").param("city", "New York"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[0].age").value(30));
    }

}