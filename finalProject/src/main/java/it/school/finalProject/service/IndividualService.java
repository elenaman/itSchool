package it.school.finalProject.service;

import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.mapper.ObjectMapper;
import it.school.finalProject.persistence.entity.Individual;
import it.school.finalProject.persistence.repository.IndividualRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualService {

    private final IndividualRepository individualRepository;
    private final ObjectMapper<IndividualDto, Individual> individualMapper;

    public IndividualService(IndividualRepository individualRepository, ObjectMapper<IndividualDto, Individual> individualMapper) {
        this.individualRepository = individualRepository;
        this.individualMapper = individualMapper;
    }

    public IndividualDto createIndividual(IndividualDto individual){
        Individual entity = individualMapper.mapToEntity(individual);
        return individualMapper.mapToDto(individualRepository.save(entity));
    }

    public List<IndividualDto> getIndividuals(){
        return individualRepository.findAll().stream()
                .map(individualMapper::mapToDto)
                .toList();
    }
}
