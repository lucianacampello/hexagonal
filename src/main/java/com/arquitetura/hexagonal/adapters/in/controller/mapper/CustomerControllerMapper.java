package com.arquitetura.hexagonal.adapters.in.controller.mapper;

import com.arquitetura.hexagonal.adapters.in.controller.request.CustomerResquest;
import com.arquitetura.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arquitetura.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerControllerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerResquest customerResquest);

    CustomerResponse toCustomerResponse(Customer customer);
}
