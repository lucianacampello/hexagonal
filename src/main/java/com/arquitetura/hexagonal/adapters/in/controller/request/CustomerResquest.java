package com.arquitetura.hexagonal.adapters.in.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResquest {
    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private String zipCode;
}
