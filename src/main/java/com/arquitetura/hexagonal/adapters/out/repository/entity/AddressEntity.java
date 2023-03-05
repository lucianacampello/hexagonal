package com.arquitetura.hexagonal.adapters.out.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    private String street;
    private String city;
    private String state;
}
