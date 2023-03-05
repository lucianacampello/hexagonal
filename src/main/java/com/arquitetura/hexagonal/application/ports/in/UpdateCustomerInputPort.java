package com.arquitetura.hexagonal.application.ports.in;

import com.arquitetura.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
