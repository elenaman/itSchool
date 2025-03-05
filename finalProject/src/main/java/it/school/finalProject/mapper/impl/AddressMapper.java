package it.school.finalProject.mapper.impl;

import it.school.finalProject.dto.AddressDto;
import it.school.finalProject.mapper.ObjectMapper;
import it.school.finalProject.persistence.entity.Address;
import it.school.finalProject.persistence.entity.Individual;
import it.school.finalProject.persistence.repository.IndividualRepository;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements ObjectMapper<AddressDto, Address> {
    private final IndividualRepository individualRepository;

    public AddressMapper(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }
    @Override
    public AddressDto mapToDto(Address address) {
        return new AddressDto(
                address.getAddressId(),
                address.getIndividual().getIndividualId(),
                address.getCountry(),
                address.getCity(),
                address.getZipCode(),
                address.getAddressLine1(),
                address.getAddressLine2(),
                address.getAddressType()
        );
    }

    @Override
    public Address mapToEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setAddressId(addressDto.getAddressId()); // Optional: If you're not auto-generating
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setZipCode(addressDto.getZipCode());
        address.setAddressLine1(addressDto.getAddressLine1());
        address.setAddressLine2(addressDto.getAddressLine2());
        address.setAddressType(addressDto.getAddressType());
        Individual individual = individualRepository.findById(addressDto.getIndividualId())
                .orElseThrow(() -> new IllegalArgumentException("Individual with ID " + addressDto.getIndividualId() + " not found"));

        address.setIndividual(individual);


        return address;
    }
}
