package com.arquitetura.hexagonal.config;

import com.arquitetura.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.arquitetura.hexagonal.adapters.out.InsertCustomerAdapter;
import com.arquitetura.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.arquitetura.hexagonal.application.core.usecase.InsertCustomerUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    @Bean
    public InsertCustomerUserCase insertCustomerUserCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                         InsertCustomerAdapter insertCustomerAdapter,
                                                         SendCpfForValidationAdapter sendCpfForValidationAdapter) {
        return new InsertCustomerUserCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }
}
