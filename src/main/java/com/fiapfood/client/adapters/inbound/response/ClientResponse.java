package com.fiapfood.client.adapters.inbound.response;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record ClientResponse(
        @Schema(description = "Client name", example = "Mario Word")
        String name,
        @Schema(description = "Client phone number", example = "1234567890")
        String phone,
        @Schema(description = "Client email", example = "mario.word@example.com")
        String email,
        @Schema(description = "Client document", example = "08197588479")
        String document,
        AddressResponse address
) { }
