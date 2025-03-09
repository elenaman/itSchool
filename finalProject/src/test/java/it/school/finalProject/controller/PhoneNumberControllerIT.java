package it.school.finalProject.controller;

import it.school.finalProject.dto.PhoneNumberDto;
import it.school.finalProject.service.PhoneNumberService;
import it.school.finalProject.validator.PhoneNumberValidator;
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
class PhoneNumberControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PhoneNumberService phoneNumberService;

    @MockitoBean
    private PhoneNumberValidator phoneNumberValidator;

    @Test
    void testGetAllPhoneNumbers() throws Exception {
        PhoneNumberDto phoneNumber = new PhoneNumberDto(1, 1, "+1", "1234567890", "MOBILE", true);

        when(phoneNumberService.getAllPhoneNumbers()).thenReturn(List.of(phoneNumber));

        mockMvc.perform(get("/api/phone-numbers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].phoneId").value(1))
                .andExpect(jsonPath("$[0].countryCode").value("+1"))
                .andExpect(jsonPath("$[0].phoneNumber").value("1234567890"))
                .andExpect(jsonPath("$[0].phoneType").value("MOBILE"))
                .andExpect(jsonPath("$[0].primary").value(true));
    }

    @Test
    void testGetPhoneNumberById() throws Exception {
        PhoneNumberDto phoneNumber = new PhoneNumberDto(1, 1, "+1", "1234567890", "MOBILE", true);

        when(phoneNumberService.getPhoneNumberById(1)).thenReturn(phoneNumber);

        mockMvc.perform(get("/api/phone-numbers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phoneId").value(1))
                .andExpect(jsonPath("$.countryCode").value("+1"))
                .andExpect(jsonPath("$.phoneNumber").value("1234567890"))
                .andExpect(jsonPath("$.phoneType").value("MOBILE"))
                .andExpect(jsonPath("$.primary").value(true));
    }

    @Test
    void testCreatePhoneNumber() throws Exception {
        PhoneNumberDto newPhoneNumber = new PhoneNumberDto(1, 1, "+1", "9876543210", "HOME", false);

        when(phoneNumberService.createPhoneNumber(any(PhoneNumberDto.class))).thenReturn(newPhoneNumber);

        mockMvc.perform(
                        post("/api/phone-numbers")
                                .contentType("application/json")
                                .content("""
                                        {
                                            "individualId": 1,
                                            "countryCode": "+1",
                                            "phoneNumber": "9876543210",
                                            "phoneType": "HOME",
                                            "primary": false
                                        }
                                        """)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phoneId").value(1))
                .andExpect(jsonPath("$.countryCode").value("+1"))
                .andExpect(jsonPath("$.phoneNumber").value("9876543210"))
                .andExpect(jsonPath("$.phoneType").value("HOME"))
                .andExpect(jsonPath("$.primary").value(false));
    }

    @Test
    void testUpdatePhoneNumber() throws Exception {
        PhoneNumberDto updatedPhoneNumber = new PhoneNumberDto(1, 1, "+44", "1122334455", "WORK", true);

        when(phoneNumberService.updatePhoneNumber(anyInt(), any(PhoneNumberDto.class))).thenReturn(updatedPhoneNumber);

        mockMvc.perform(
                        put("/api/phone-numbers/1")
                                .contentType("application/json")
                                .content("""
                                        {
                                            "individualId": 1,
                                            "countryCode": "+44",
                                            "phoneNumber": "1122334455",
                                            "phoneType": "WORK",
                                            "primary": true
                                        }
                                        """)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phoneId").value(1))
                .andExpect(jsonPath("$.countryCode").value("+44"))
                .andExpect(jsonPath("$.phoneNumber").value("1122334455"))
                .andExpect(jsonPath("$.phoneType").value("WORK"))
                .andExpect(jsonPath("$.primary").value(true));
    }

    @Test
    void testDeletePhoneNumber() throws Exception {
        mockMvc.perform(delete("/api/phone-numbers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Phone number deleted successfully."));
    }
}
