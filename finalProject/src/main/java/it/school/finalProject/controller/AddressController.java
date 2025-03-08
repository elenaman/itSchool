package it.school.finalProject.controller;

import it.school.finalProject.dto.AddressDto;
import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.service.AddressService;
import it.school.finalProject.service.IndividualService;
import it.school.finalProject.validator.AddressValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;
    private final AddressValidator addressValidator;
    private final IndividualService individualService;

    public AddressController(AddressService addressService, AddressValidator addressValidator, IndividualService individualService) {
        this.addressService = addressService;
        this.addressValidator = addressValidator;
        this.individualService = individualService;
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable int id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        addressValidator.validate(addressDto);
        return ResponseEntity.ok(addressService.createAddress(addressDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable int id, @RequestBody AddressDto addressDto) {
        addressValidator.validate(addressDto); // Validate before processing
        return ResponseEntity.ok(addressService.updateAddress(id, addressDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("Address deleted successfully.");
    }

    @GetMapping("/by-individual/{individualId}")
    public ResponseEntity<List<AddressDto>> getAddressesByIndividual(@PathVariable int individualId) {
        return ResponseEntity.ok(addressService.getAddressesByIndividual(individualId));
    }

    @GetMapping("/by-city")
    public ResponseEntity<List<IndividualDto>> getIndividualsByCity(@RequestParam String city) {
        return ResponseEntity.ok(addressService.getIndividualsByCity(city));
    }




}