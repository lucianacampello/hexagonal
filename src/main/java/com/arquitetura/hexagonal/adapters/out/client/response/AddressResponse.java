package com.arquitetura.hexagonal.adapters.out.client.response;

import com.arquitetura.hexagonal.application.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private UUID id;
    private String name;
    private String cpf;
    private Address address;
    private boolean isValidCpf;
}
