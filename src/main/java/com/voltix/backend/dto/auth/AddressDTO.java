package com.voltix.backend.dto.auth;

import lombok.*;
import lombok.AllArgsConstructor;
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

    private Long userId;

}
