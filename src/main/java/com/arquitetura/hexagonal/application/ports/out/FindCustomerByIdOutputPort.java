package com.arquitetura.hexagonal.application.ports.out;

import com.arquitetura.hexagonal.application.core.domain.Customer;

import java.util.Optional;
import java.util.UUID;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(UUID id);
}
