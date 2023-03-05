package com.arquitetura.hexagonal.adapters.out;

import com.arquitetura.hexagonal.adapters.out.repository.CustomerRepository;
import com.arquitetura.hexagonal.adapters.out.repository.mapper.CustomerRepositoryMapper;
import com.arquitetura.hexagonal.application.core.domain.Customer;
import com.arquitetura.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {
    private final CustomerRepository repository;
    private final CustomerRepositoryMapper mapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = mapper.toCustomerEntity(customer);
        repository.save(customerEntity);
    }
}
