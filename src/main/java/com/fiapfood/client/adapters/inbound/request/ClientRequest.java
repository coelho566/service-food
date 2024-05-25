package com.fiapfood.client.adapters.inbound.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record ClientRequest(

        @NotBlank(message = "O nome não pode estar em branco")
        @Schema(description = "Client name", example = "Mario Word")
        String name,
        @Schema(description = "Client phone number", example = "1234567890")
        String phone,
        @Email(message = "Email deve ser válido")
        @Schema(description = "Client email", example = "mario.word@example.com")
        String email,
        @NotBlank(message = "O documento não pode estar em branco")
        @Schema(description = "Client document", example = "08197588479")
        String document,
        @Schema(description = "Document type", example = "CPF")
        String documentType,
        @Schema(description = "Allow notifications", example = "true")
        boolean allowNotification,
        @Schema(description = "Client postal code", example = "01311-000")
        String postalCode,
        @Schema(description = "Client number address", example = "1457")
        String numberAddress
) { }
