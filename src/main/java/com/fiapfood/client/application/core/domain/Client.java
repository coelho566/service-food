package com.fiapfood.client.application.core.domain;

public record Client(
        String name,
        String phone,
        String email,
        String document,
        String documentType,
        Boolean allowNotification,
        Address address
) {
}
