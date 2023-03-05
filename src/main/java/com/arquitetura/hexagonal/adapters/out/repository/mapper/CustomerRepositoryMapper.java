package com.arquitetura.hexagonal.adapters.out.repository.mapper;

import com.arquitetura.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.arquitetura.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerRepositoryMapper {
    CustomerEntity toCustomerEntity(Customer customer);
}
