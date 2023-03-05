package com.arquitetura.hexagonal.adapters.in.controller;

import com.arquitetura.hexagonal.adapters.in.controller.mapper.CustomerControllerMapper;
import com.arquitetura.hexagonal.adapters.in.controller.request.CustomerResquest;
import com.arquitetura.hexagonal.application.ports.in.InsertCustomerInputPortImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private InsertCustomerInputPortImp customerInputPortImp;
    private CustomerControllerMapper mapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerResquest request) {
        var customer = mapper.toCustomer(request);
        customerInputPortImp.insert(customer, request.getZipCode());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
