package it.school.finalProject.validator;

import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.exception.InvalidPayloadException;
import org.springframework.stereotype.Component;

@Component
public class IndividualValidator {

    public void validateIndividual(IndividualDto individual){
        if(individual == null){
            throw  new InvalidPayloadException("Individual cannot be null");
        }
    }
}
