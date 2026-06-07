package com.voltix.backend.controller;

import com.voltix.backend.dto.auth.AddressDTO;
import com.voltix.backend.model.Address;
import com.voltix.backend.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public Address create(@RequestBody AddressDTO dto, Authentication authentication) {
        return addressService.create(dto, authentication);
    }

    @GetMapping
    public List<Address> findAll(Authentication authentication) {
        return addressService.findAll(authentication);
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id, Authentication authentication) {
        return addressService.findById(id, authentication);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable Long id, @RequestBody AddressDTO dto, Authentication authentication) {
        return addressService.update(id, dto, authentication);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, Authentication authentication) {
        addressService.delete(id, authentication);
    }
}
