package com.ensas.shoppybackendspring.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@Table(name = "ADDRESS")
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String country;
    private String state;
    private String zipCode;
    @OneToMany
    @PrimaryKeyJoinColumn
    private List<Order> orders;
}
