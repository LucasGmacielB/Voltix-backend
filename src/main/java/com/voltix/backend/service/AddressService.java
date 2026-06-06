package com.voltix.backend.service;

import com.voltix.backend.dto.auth.AddressDTO;
import com.voltix.backend.model.Address;
import com.voltix.backend.model.User;
import com.voltix.backend.repository.AddressRepository;
import com.voltix.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

  public List<Address> findAll() {
    return addressRepository.findAll();
}

    public Address create(AddressDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Address address = new Address();

        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setNeighborhood(dto.getNeighborhood());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());
        address.setUser(user);

        return addressRepository.save(address);
    }

    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public Address update(Long id, AddressDTO dto) {

        Address address = findById(id);

        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setNeighborhood(dto.getNeighborhood());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());

        return addressRepository.save(address);
    }

    public void delete(Long id) {
        Address address = findById(id);
        addressRepository.delete(address);
    }
}