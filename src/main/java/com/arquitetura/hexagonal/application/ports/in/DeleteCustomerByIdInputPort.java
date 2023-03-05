package com.arquitetura.hexagonal.application.ports.in;

import java.util.UUID;

public interface DeleteCustomerByIdInputPort {
    void delete(UUID id);
}
