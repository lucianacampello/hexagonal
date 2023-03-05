package com.arquitetura.hexagonal.application.core.usecase;

import com.arquitetura.hexagonal.application.core.domain.Customer;
import com.arquitetura.hexagonal.application.ports.in.InsertCustomerInputPortImp;
import com.arquitetura.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arquitetura.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUserCase implements InsertCustomerInputPortImp {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUserCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                  InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
