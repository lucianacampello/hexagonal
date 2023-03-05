package com.arquitetura.hexagonal.application.ports.in;

import com.arquitetura.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPortImp {
    void insert(Customer customer, String zipCode);
}
