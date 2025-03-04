package it.school.finalProject.controller;

import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.service.IndividualService;
import it.school.finalProject.validator.IndividualValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individuals")
public class IndividualController {
    private final IndividualService individualService;
    private final IndividualValidator individualValidator;

    public IndividualController(IndividualService individualService, IndividualValidator individualValidator){
        this.individualService = individualService;
        this.individualValidator = individualValidator;
    }

    @PostMapping
    public ResponseEntity<IndividualDto> createIndividual(@RequestBody IndividualDto individual){
        individualValidator.validateIndividual(individual);
        return new ResponseEntity<>(individualService.createIndividual(individual), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IndividualDto>> getIndividuals(){
        return ResponseEntity.ok(individualService.getIndividuals());
    }
}
