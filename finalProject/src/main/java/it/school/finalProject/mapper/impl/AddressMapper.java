package it.school.finalProject.mapper.impl;

import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.mapper.ObjectMapper;
import it.school.finalProject.persistence.entity.Address;

public class AddressMapper implements ObjectMapper<IndividualDto.AddressDto, Address> {
    @Override
    public IndividualDto.AddressDto mapToDto(Address address) {
        return new IndividualDto.AddressDto(
                address.getAddressLine1(),
                address.getAddressLine2(),
                address.getZipCode(),
                address.getCity(),
                address.getCountry(),
                address.getAddressType()
        );
    }

    @Override
    public Address mapToEntity(IndividualDto.AddressDto addressDto) {
        Address address = new Address();
        address.setAddressLine1(addressDto.getAddressLine1());
        address.setAddressLine2(addressDto.getAddressLine2());
        address.setCity(addressDto.getCity());
        address.setZipCode(addressDto.getZipCode());
        address.setCountry(addressDto.getCountry());
        address.setAddressType(addressDto.getAddressType());

        return address;
    }
}
