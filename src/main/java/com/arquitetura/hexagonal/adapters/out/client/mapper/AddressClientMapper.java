package com.arquitetura.hexagonal.adapters.out.client.mapper;

import com.arquitetura.hexagonal.adapters.out.client.response.AddressResponse;
import com.arquitetura.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressClientMapper {
    Address toAddres(AddressResponse addressResponse);
}
