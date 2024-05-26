package com.fiapfood.product.application.core.exception;

public class ProductException extends RuntimeException{


    public ProductException() {
    }

    public ProductException(String message) {
        super(message);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
