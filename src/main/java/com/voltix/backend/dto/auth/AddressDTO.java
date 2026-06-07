package com.voltix.backend.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String zipCode;

    private String state;
}
