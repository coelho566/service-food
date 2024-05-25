package com.fiapfood.client.application.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Address(
        @JsonProperty("cep")
        String postalCode,
        @JsonProperty("logradouro")
        String street,

        @JsonProperty("uf")
        String state,

        @JsonProperty("localidade")
        String city
) {
}
