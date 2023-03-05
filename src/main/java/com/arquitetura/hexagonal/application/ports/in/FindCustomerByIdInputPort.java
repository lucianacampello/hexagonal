package com.arquitetura.hexagonal.application.ports.in;

import com.arquitetura.hexagonal.application.core.domain.Customer;

import java.util.UUID;

public interface FindCustomerByIdInputPort {
    Customer find(UUID id);
}
