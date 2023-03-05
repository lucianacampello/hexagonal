package com.arquitetura.hexagonal.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private UUID id;
    private String name;
    private String cpf;
    private Address address;
    private boolean isValidCpf;
}
