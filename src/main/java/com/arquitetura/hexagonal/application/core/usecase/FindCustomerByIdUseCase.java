package com.arquitetura.hexagonal.application.core.usecase;

import com.arquitetura.hexagonal.application.core.domain.Customer;
import com.arquitetura.hexagonal.application.core.exception.NotFoundException;
import com.arquitetura.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arquitetura.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {
    private final FindCustomerByIdOutputPort findClientByIdOutputPort;

    @Override
    public Customer find(UUID id) throws NotFoundException {
        return findClientByIdOutputPort.find(id).orElseThrow(() -> new NotFoundException("Customer not found."));
    }
}
