package it.school.finalProject.mapper.impl;

import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.mapper.ObjectMapper;
import it.school.finalProject.persistence.entity.IdentificationDocument;
import it.school.finalProject.persistence.entity.Individual;
import org.springframework.stereotype.Component;

@Component
public class IndividualMapper implements ObjectMapper<IndividualDto, Individual> {


    private final ObjectMapper<IndividualDto.IdentificationDocumentDto, IdentificationDocument> identificationDocumentMapper;

    public IndividualMapper(ObjectMapper<IndividualDto.IdentificationDocumentDto, IdentificationDocument> identificationDocumentMapper) {
        this.identificationDocumentMapper = identificationDocumentMapper;
    }

    @Override
    public IndividualDto mapToDto(Individual individual) {
        return new IndividualDto(
                individual.getIndividualId(),
                individual.getFirstName(),
                individual.getLastName(),
                individual.getAge(),
                individual.isMemberActive(),
                individual.getDateJoined(),
                identificationDocumentMapper.mapToDto(individual.getIdentificationDocument())
        );
    }

    @Override
    public Individual mapToEntity(IndividualDto individualDto) {
        Individual individual = new Individual();

        individual.setFirstName(individualDto.getFirstName());
        individual.setLastName(individualDto.getLastName());
        individual.setAge(individualDto.getAge());
        individual.setMemberActive(individualDto.isMemberActive());
        individual.setDateJoined(individualDto.getDateJoined());

        individual.setIdentificationDocument(identificationDocumentMapper.mapToEntity(individualDto.getIdentificationDocument()));
        return individual;
    }
}
