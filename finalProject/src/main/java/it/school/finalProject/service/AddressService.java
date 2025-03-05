package it.school.finalProject.service;

import it.school.finalProject.dto.AddressDto;
import it.school.finalProject.exception.ResourceNotFoundException;
import it.school.finalProject.mapper.ObjectMapper;
import it.school.finalProject.persistence.entity.Address;
import it.school.finalProject.persistence.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final ObjectMapper<AddressDto, Address> addressMapper;


    public AddressService(AddressRepository addressRepository, ObjectMapper<AddressDto, Address> addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public List<AddressDto> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(addressMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public AddressDto getAddressById(int id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with ID: " + id));
        return addressMapper.mapToDto(address);
    }

    public AddressDto createAddress(AddressDto addressDto) {
        Address address = addressMapper.mapToEntity(addressDto);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.mapToDto(savedAddress);
    }

    public AddressDto updateAddress(int id, AddressDto addressDto) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with ID: " + id));

        existingAddress.setCountry(addressDto.getCountry());
        existingAddress.setCity(addressDto.getCity());
        existingAddress.setZipCode(addressDto.getZipCode());
        existingAddress.setAddressLine1(addressDto.getAddressLine1());
        existingAddress.setAddressLine2(addressDto.getAddressLine2());
        existingAddress.setAddressType(addressDto.getAddressType());

        Address updatedAddress = addressRepository.save(existingAddress);
        return addressMapper.mapToDto(updatedAddress);
    }

    public void deleteAddress(int id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with ID: " + id));
        addressRepository.delete(address);
    }
}
