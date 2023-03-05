package com.arquitetura.hexagonal.adapters.in.consumer;

import com.arquitetura.hexagonal.adapters.in.consumer.mapper.CostumerMessageConsumerMapper;
import com.arquitetura.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.arquitetura.hexagonal.application.ports.in.UpdateCustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceiveValidatedCpfConsumer {
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final CostumerMessageConsumerMapper mapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "hexagonal")
    public void receive(CustomerMessage customerMessage) {
        var customer = mapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
