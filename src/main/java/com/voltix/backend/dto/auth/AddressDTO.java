package com.voltix.backend.dto.auth;

import lombok.*;


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
    
    private String state;

}
