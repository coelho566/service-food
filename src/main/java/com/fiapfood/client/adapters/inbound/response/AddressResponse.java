package com.fiapfood.client.adapters.inbound.response;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record AddressResponse(
        @Schema(description = "Client postal code", example = "01311-000")
        String postalCode,
        @Schema(description = "Client street address", example = "Avenida Paulista")
        String street,
        @Schema(description = "Client state", example = "SP")
        String state,
        @Schema(description = "Client city", example = "Sao Paulo")
        String city
) {
}
