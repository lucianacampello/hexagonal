package com.arquitetura.hexagonal.adapters.out;

import com.arquitetura.hexagonal.adapters.out.client.FindAddresByZipCodeClient;
import com.arquitetura.hexagonal.adapters.out.client.mapper.AddressClientMapper;
import com.arquitetura.hexagonal.application.core.domain.Address;
import com.arquitetura.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddresByZipCodeClient client;
    private final AddressClientMapper mapper;

    @Override
    public Address find(String zipCode) {
        var response = client.find(zipCode);
        return mapper.toAddres(response);
    }
}
