package com.arquitetura.hexagonal.application.core.usecase;

import com.arquitetura.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.arquitetura.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arquitetura.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    @Override
    public void delete(UUID id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
