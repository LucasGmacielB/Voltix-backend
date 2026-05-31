package com.voltix.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipCode;
    
    private String number;

    private String neighborhood;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
