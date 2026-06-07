package com.voltix.backend.service;

import com.voltix.backend.dto.auth.AddressDTO;
import com.voltix.backend.model.Address;
import com.voltix.backend.model.User;
import com.voltix.backend.repository.AddressRepository;
import com.voltix.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public List<Address> findAll(Authentication authentication) {
        User user = getAuthenticatedUser(authentication);
        return addressRepository.findByUserId(user.getId());
    }

    public Address create(AddressDTO dto, Authentication authentication) {
        User user = getAuthenticatedUser(authentication);

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

    public Address findById(Long id, Authentication authentication) {
        User user = getAuthenticatedUser(authentication);
        return findByIdAndUser(id, user.getId());
    }

    public Address update(Long id, AddressDTO dto, Authentication authentication) {
        User user = getAuthenticatedUser(authentication);
        Address address = findByIdAndUser(id, user.getId());

        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setNeighborhood(dto.getNeighborhood());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());

        return addressRepository.save(address);
    }

    public void delete(Long id, Authentication authentication) {
        User user = getAuthenticatedUser(authentication);
        Address address = findByIdAndUser(id, user.getId());
        addressRepository.delete(address);
    }

    private User getAuthenticatedUser(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()
                || "anonymousUser".equals(authentication.getName())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario nao autenticado");
        }

        return userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario autenticado nao encontrado"));
    }

    private Address findByIdAndUser(Long id, Long userId) {
        return addressRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco nao encontrado"));
    }
}
