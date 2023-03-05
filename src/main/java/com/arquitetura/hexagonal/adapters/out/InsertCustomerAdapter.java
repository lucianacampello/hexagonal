package com.arquitetura.hexagonal.adapters.out;

import com.arquitetura.hexagonal.adapters.out.repository.CustomerRepository;
import com.arquitetura.hexagonal.adapters.out.repository.mapper.CustomerRepositoryMapper;
import com.arquitetura.hexagonal.application.core.domain.Customer;
import com.arquitetura.hexagonal.application.ports.out.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {
    private final CustomerRepository repository;
    private final CustomerRepositoryMapper mapper;

    @Override
    public void insert(Customer customer) {
        repository.save(mapper.toCustomerEntity(customer));
    }
}
