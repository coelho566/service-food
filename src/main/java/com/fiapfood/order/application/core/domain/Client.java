package com.fiapfood.order.application.core.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Schema(description = "Nome da pessoa", example = "João da Silva")
    @NotBlank(message = "O nome não pode estar em branco")
    private String name;

    @Schema(description = "Número de telefone", example = "+55 11 98765-4321")
    @NotBlank(message = "O telefone não pode estar em branco")
    private String phone;

    @Schema(description = "Endereço de e-mail", example = "joao.silva@example.com")
    private String email;

    @Schema(description = "Número do documento", example = "123.456.789-00")
    @NotBlank(message = "O documento não pode estar em branco")
    private String document;

    @Valid
    @Schema(description = "Endereço completo")
    private Address address;
}
