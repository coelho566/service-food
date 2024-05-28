package com.fiapfood.product.application.config;

import com.fiapfood.product.application.core.usecase.ProductUseCase;
import com.fiapfood.product.application.ports.out.ProductRepositoryPort;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;

@Dependent
public class Config {

    @Default
    public ProductUseCase clientUseCase(ProductRepositoryPort productRepositoryPort){
        return new ProductUseCase(productRepositoryPort);
    }
}
