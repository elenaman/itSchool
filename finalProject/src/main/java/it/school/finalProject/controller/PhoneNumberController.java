package it.school.finalProject.controller;

import it.school.finalProject.dto.PhoneNumberDto;
import it.school.finalProject.service.PhoneNumberService;
import it.school.finalProject.validator.PhoneNumberValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phone-numbers")
public class PhoneNumberController {

    private final PhoneNumberService phoneNumberService;
    private final PhoneNumberValidator phoneNumberValidator;

    public PhoneNumberController(PhoneNumberService phoneNumberService, PhoneNumberValidator phoneNumberValidator) {
        this.phoneNumberService = phoneNumberService;
        this.phoneNumberValidator = phoneNumberValidator;
    }

    @GetMapping
    public ResponseEntity<List<PhoneNumberDto>> getAllPhoneNumbers() {
        return ResponseEntity.ok(phoneNumberService.getAllPhoneNumbers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneNumberDto> getPhoneNumberById(@PathVariable int id) {
        return ResponseEntity.ok(phoneNumberService.getPhoneNumberById(id));
    }

    @PostMapping
    public ResponseEntity<PhoneNumberDto> createPhoneNumber(@RequestBody PhoneNumberDto phoneNumberDto) {
        phoneNumberValidator.validate(phoneNumberDto);
        return ResponseEntity.ok(phoneNumberService.createPhoneNumber(phoneNumberDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhoneNumberDto> updatePhoneNumber(@PathVariable int id, @RequestBody PhoneNumberDto phoneNumberDto) {
        phoneNumberValidator.validate(phoneNumberDto);
        return ResponseEntity.ok(phoneNumberService.updatePhoneNumber(id, phoneNumberDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePhoneNumber(@PathVariable int id) {
        phoneNumberService.deletePhoneNumber(id);
        return ResponseEntity.ok("Phone number deleted successfully.");
    }
}
