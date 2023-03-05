package com.arquitetura.hexagonal.adapters.out.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "customers")
public class CustomerEntity {
    @Id
    private UUID id;
    private String name;
    private String cpf;
    private AddressEntity address;
    private boolean isValidCpf;
}
