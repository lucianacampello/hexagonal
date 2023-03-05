package com.arquitetura.hexagonal.adapters.out.repository;

import com.arquitetura.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CustomerRepository extends MongoRepository<CustomerEntity, UUID> {
}
