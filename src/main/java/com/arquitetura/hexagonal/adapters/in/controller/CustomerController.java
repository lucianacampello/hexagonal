package com.arquitetura.hexagonal.adapters.in.controller;

import com.arquitetura.hexagonal.adapters.in.controller.mapper.CustomerControllerMapper;
import com.arquitetura.hexagonal.adapters.in.controller.request.CustomerResquest;
import com.arquitetura.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arquitetura.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.arquitetura.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arquitetura.hexagonal.application.ports.in.InsertCustomerInputPortImp;
import com.arquitetura.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private InsertCustomerInputPortImp insertCustomerInputPortImp;
    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;
    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;
    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
    @Autowired
    private CustomerControllerMapper mapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerResquest request) {
        var customer = mapper.toCustomer(request);
        insertCustomerInputPortImp.insert(customer, request.getZipCode());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final UUID id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = mapper.toCustomerResponse(customer);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final UUID id, @Valid @RequestBody CustomerResquest request) {
        var customer = mapper.toCustomer(request);
        customer.setId(id);
        updateCustomerInputPort.update(customer, request.getZipCode());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final UUID id) {
        deleteCustomerByIdInputPort.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
