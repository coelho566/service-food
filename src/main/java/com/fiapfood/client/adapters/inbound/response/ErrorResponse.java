package com.fiapfood.client.adapters.inbound.response;

import lombok.Data;

@Data
public class ErrorResponse {

    private String code;
    private String menssage;
}
