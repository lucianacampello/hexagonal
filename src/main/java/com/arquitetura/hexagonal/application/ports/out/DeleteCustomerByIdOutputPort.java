package com.arquitetura.hexagonal.application.ports.out;

import java.util.UUID;

public interface DeleteCustomerByIdOutputPort {
    void delete(UUID id);
}
