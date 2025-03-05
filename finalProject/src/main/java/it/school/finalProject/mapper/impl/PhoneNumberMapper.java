package it.school.finalProject.mapper.impl;

import it.school.finalProject.dto.PhoneNumberDto;
import it.school.finalProject.mapper.ObjectMapper;
import it.school.finalProject.persistence.entity.Individual;
import it.school.finalProject.persistence.entity.PhoneNumber;
import it.school.finalProject.persistence.repository.IndividualRepository;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberMapper implements ObjectMapper<PhoneNumberDto, PhoneNumber> {

    private final IndividualRepository individualRepository;

    public PhoneNumberMapper(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }
    @Override
    public PhoneNumberDto mapToDto(PhoneNumber phoneNumber) {
        return new PhoneNumberDto(
                phoneNumber.getPhoneId(),
                phoneNumber.getIndividual().getIndividualId(),
                phoneNumber.getCountryCode(),
                phoneNumber.getPhoneNumber(),
                phoneNumber.getPhoneType(),
                phoneNumber.isPrimary()
        );
    }

    @Override
    public PhoneNumber mapToEntity(PhoneNumberDto phoneNumberDto) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneId(phoneNumberDto.getPhoneId());
        phoneNumber.setCountryCode(phoneNumberDto.getCountryCode());
        phoneNumber.setPhoneNumber(phoneNumberDto.getPhoneNumber());
        phoneNumber.setPhoneType(phoneNumberDto.getPhoneType());
        phoneNumber.setPrimary(phoneNumberDto.isPrimary());

        Individual individual = individualRepository.findById(phoneNumberDto.getIndividualId())
                .orElseThrow(() -> new IllegalArgumentException("Individual with ID " + phoneNumberDto.getIndividualId() + " not found"));

        phoneNumber.setIndividual(individual);

        return phoneNumber;
    }
}
