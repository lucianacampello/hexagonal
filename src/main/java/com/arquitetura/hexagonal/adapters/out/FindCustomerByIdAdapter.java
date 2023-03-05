package com.arquitetura.hexagonal.adapters.out;

import com.arquitetura.hexagonal.adapters.out.repository.CustomerRepository;
import com.arquitetura.hexagonal.adapters.out.repository.mapper.CustomerRepositoryMapper;
import com.arquitetura.hexagonal.application.core.domain.Customer;
import com.arquitetura.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {
    private final CustomerRepository repository;
    private final CustomerRepositoryMapper mapper;

    @Override
    public Optional<Customer> find(UUID id) {
        var customerEntity = repository.findById(id);
        return customerEntity.map(mapper::toCustomer);
    }
}
