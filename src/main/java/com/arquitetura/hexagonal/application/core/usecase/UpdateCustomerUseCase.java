package com.arquitetura.hexagonal.application.core.usecase;

import com.arquitetura.hexagonal.application.core.domain.Customer;
import com.arquitetura.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arquitetura.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.arquitetura.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arquitetura.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateCustomerUseCase implements UpdateCustomerInputPort {
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
