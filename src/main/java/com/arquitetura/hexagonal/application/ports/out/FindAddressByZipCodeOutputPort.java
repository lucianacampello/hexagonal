package com.arquitetura.hexagonal.application.ports.out;

import com.arquitetura.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
