package com.arquitetura.hexagonal.adapters.in.consumer.mapper;

import com.arquitetura.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.arquitetura.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CostumerMessageConsumerMapper {
    
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
