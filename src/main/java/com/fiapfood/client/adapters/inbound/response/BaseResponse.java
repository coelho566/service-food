package com.fiapfood.client.adapters.inbound.response;

import lombok.Data;

@Data
public class BaseResponse<T> {

    T data;
    private ErrorResponse error;

    public BaseResponse() {
    }

    public BaseResponse(T data) {
        this.data = data;
    }

    public BaseResponse(ErrorResponse error) {
        this.error = error;
    }
}
