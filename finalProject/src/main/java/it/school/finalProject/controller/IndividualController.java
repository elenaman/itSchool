package it.school.finalProject.controller;

import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.service.IndividualService;
import it.school.finalProject.validator.IndividualValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individuals")
public class IndividualController {

    private final IndividualService individualService;
    private final IndividualValidator individualValidator;

    public IndividualController(IndividualService individualService, IndividualValidator individualValidator) {
        this.individualService = individualService;
        this.individualValidator = individualValidator;
    }

    @GetMapping
    public ResponseEntity<List<IndividualDto>> getAllIndividuals() {
        return ResponseEntity.ok(individualService.getAllIndividuals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndividualDto> getIndividualById(@PathVariable int id) {
        return ResponseEntity.ok(individualService.getIndividualById(id));
    }

    @PostMapping
    public ResponseEntity<IndividualDto> createIndividual(@RequestBody IndividualDto individualDto) {
        individualValidator.validate(individualDto);
        return ResponseEntity.ok(individualService.createIndividual(individualDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IndividualDto> updateIndividual(@PathVariable int id, @RequestBody IndividualDto individualDto) {
        individualValidator.validate(individualDto);
        return ResponseEntity.ok(individualService.updateIndividual(id, individualDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIndividual(@PathVariable int id) {
        individualService.deleteIndividual(id);
        return ResponseEntity.ok("Individual deleted successfully.");
    }

    @GetMapping("/active-over-a-year")
    public ResponseEntity<List<IndividualDto>> getActiveIndividualsOverAYear() {
        return ResponseEntity.ok(individualService.getActiveIndividualsOverAYear());
    }

    @GetMapping("/without-accounts")
    public ResponseEntity<List<IndividualDto>> getIndividualsWithoutAccounts() {
        return ResponseEntity.ok(individualService.getIndividualsWithoutAccounts());
    }

    @GetMapping("/search")
    public ResponseEntity<List<IndividualDto>> searchIndividuals(@RequestParam String name) {
        return ResponseEntity.ok(individualService.searchIndividualsByName(name));
    }

    @GetMapping("/{id}/loan-eligibility")
    public ResponseEntity<Boolean> checkLoanEligibility(@PathVariable int id) {
        return ResponseEntity.ok(individualService.checkLoanEligibility(id));
    }

    @GetMapping("/multiple-addresses")
    public ResponseEntity<List<IndividualDto>> getIndividualsWithMultipleAddresses() {
        return ResponseEntity.ok(individualService.getIndividualsWithMultipleAddresses());
    }


}
