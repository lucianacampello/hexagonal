package com.arquitetura.hexagonal.application.ports.out;

import com.arquitetura.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
