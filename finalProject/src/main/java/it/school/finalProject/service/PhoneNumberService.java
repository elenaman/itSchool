package it.school.finalProject.service;

import it.school.finalProject.dto.PhoneNumberDto;
import it.school.finalProject.exception.ResourceNotFoundException;
import it.school.finalProject.mapper.ObjectMapper;
import it.school.finalProject.persistence.entity.PhoneNumber;
import it.school.finalProject.persistence.repository.PhoneNumberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {

    private final PhoneNumberRepository phoneNumberRepository;
    private final ObjectMapper<PhoneNumberDto, PhoneNumber> phoneNumberMapper;

    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository, ObjectMapper<PhoneNumberDto, PhoneNumber> phoneNumberMapper) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.phoneNumberMapper = phoneNumberMapper;
    }

    public List<PhoneNumberDto> getAllPhoneNumbers() {
        return phoneNumberRepository.findAll()
                .stream()
                .map(phoneNumberMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public PhoneNumberDto getPhoneNumberById(int id) {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Phone number not found with ID: " + id));
        return phoneNumberMapper.mapToDto(phoneNumber);
    }

    public PhoneNumberDto createPhoneNumber(PhoneNumberDto phoneNumberDto) {
        PhoneNumber phoneNumber = phoneNumberMapper.mapToEntity(phoneNumberDto);
        PhoneNumber savedPhoneNumber = phoneNumberRepository.save(phoneNumber);
        return phoneNumberMapper.mapToDto(savedPhoneNumber);
    }

    public PhoneNumberDto updatePhoneNumber(int id, PhoneNumberDto phoneNumberDto) {
        PhoneNumber existingPhoneNumber = phoneNumberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Phone number not found with ID: " + id));

        existingPhoneNumber.setCountryCode(phoneNumberDto.getCountryCode());
        existingPhoneNumber.setPhoneNumber(phoneNumberDto.getPhoneNumber());
        existingPhoneNumber.setPhoneType(phoneNumberDto.getPhoneType());
        existingPhoneNumber.setPrimary(phoneNumberDto.isPrimary());

        PhoneNumber updatedPhoneNumber = phoneNumberRepository.save(existingPhoneNumber);
        return phoneNumberMapper.mapToDto(updatedPhoneNumber);
    }

    public void deletePhoneNumber(int id) {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Phone number not found with ID: " + id));
        phoneNumberRepository.delete(phoneNumber);
    }
}
