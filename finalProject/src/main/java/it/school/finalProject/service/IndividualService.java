package it.school.finalProject.service;

import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.exception.ResourceNotFoundException;
import it.school.finalProject.mapper.impl.IndividualMapper;
import it.school.finalProject.persistence.entity.Individual;
import it.school.finalProject.persistence.repository.IndividualRepository;
import it.school.finalProject.validator.IndividualValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndividualService {

    private final IndividualRepository individualRepository;
    private final IndividualMapper individualMapper;
    private final IndividualValidator individualValidator;

    public IndividualService(IndividualRepository individualRepository, IndividualMapper individualMapper, IndividualValidator individualValidator) {
        this.individualRepository = individualRepository;
        this.individualMapper = individualMapper;
        this.individualValidator = individualValidator;
    }

    public List<IndividualDto> getAllIndividuals() {
        return individualRepository.findAll().stream()
                .map(individualMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public IndividualDto getIndividualById(int id) {
        Individual individual = individualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Individual not found with id: " + id));
        return individualMapper.mapToDto(individual);
    }

    @Transactional
    public IndividualDto createIndividual(IndividualDto individualDto) {
        individualValidator.validate(individualDto);
        Individual individual = individualMapper.mapToEntity(individualDto);
        Individual savedIndividual = individualRepository.save(individual);
        return individualMapper.mapToDto(savedIndividual);
    }

    @Transactional
    public IndividualDto updateIndividual(int id, IndividualDto individualDto) {
        individualValidator.validate(individualDto);
        Individual existingIndividual = individualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Individual not found with id: " + id));

        Individual updatedIndividual = individualMapper.mapToEntity(individualDto);
        updatedIndividual.setIndividualId(existingIndividual.getIndividualId());

        Individual savedIndividual = individualRepository.save(updatedIndividual);
        return individualMapper.mapToDto(savedIndividual);
    }

    @Transactional
    public void deleteIndividual(int id) {
        Individual individual = individualRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Individual not found with id: " + id));

        if (!individual.getAddress().isEmpty() || !individual.getPhoneNumber().isEmpty()) {
            throw new IllegalStateException("Cannot delete individual with linked addresses or phone numbers.");
        }

        individualRepository.deleteById(id);
    }

    public List<IndividualDto> getActiveIndividualsOverAYear() {
        return individualRepository.findByDateJoinedBefore(String.valueOf(LocalDate.now().minusYears(1)))
                .stream()
                .map(individual -> new IndividualDto(individual.getIndividualId(), individual.getFirstName(),
                        individual.getLastName(), individual.getAge(), individual.isMemberActive(),
                        individual.getDateJoined(), null))
                .collect(Collectors.toList());
    }

    public List<IndividualDto> getIndividualsWithoutAccounts() {
        return individualRepository.findByAccountsIsEmpty()
                .stream()
                .map(individual -> new IndividualDto(individual.getIndividualId(), individual.getFirstName(),
                        individual.getLastName(), individual.getAge(), individual.isMemberActive(),
                        individual.getDateJoined(), null))
                .collect(Collectors.toList());
    }

    public List<IndividualDto> searchIndividualsByName(String name) {
        return individualRepository.findByFirstNameContainingOrLastNameContaining(name, name)
                .stream()
                .map(individual -> new IndividualDto(individual.getIndividualId(), individual.getFirstName(),
                        individual.getLastName(), individual.getAge(), individual.isMemberActive(),
                        individual.getDateJoined(), null))
                .collect(Collectors.toList());
    }

    public boolean checkLoanEligibility(int individualId) {
        Individual individual = individualRepository.findById(individualId)
                .orElseThrow(() -> new ResourceNotFoundException("Individual not found with id: " + individualId));
        return individual.isMemberActive();
    }

    public List<IndividualDto> getIndividualsWithMultipleAddresses() {
        List<Individual> individuals = individualRepository.findIndividualsWithMultipleAddresses();

        if (individuals.isEmpty()) {
            throw new ResourceNotFoundException("No individuals found with multiple addresses.");
        }

        return individuals.stream()
                .map(individualMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
