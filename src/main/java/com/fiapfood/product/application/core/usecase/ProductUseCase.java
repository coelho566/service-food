package com.fiapfood.product.application.core.usecase;

import com.fiapfood.product.adapters.inbound.response.ProductResponse;
import com.fiapfood.product.application.core.domain.CategoryEnum;
import com.fiapfood.product.application.core.domain.Product;
import com.fiapfood.product.application.core.exception.ProductException;
import com.fiapfood.product.application.ports.in.ProductUseCasePort;
import com.fiapfood.product.application.ports.out.ProductRepositoryPort;

import java.util.List;

public class ProductUseCase implements ProductUseCasePort {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductUseCase(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public void insertProduct(Product productRequest) {
        if (CategoryEnum.hasDescription(productRequest.category()))
            productRepositoryPort.insertProduct(productRequest);
        else
            throw new ProductException("Category does not exist, inform the 'LANCHE', 'ACOMPANHAMENTO', 'SOBREMESA' and 'BEBIDA' type categories");

    }

    @Override
    public ProductResponse updateProduct(String productId, Product productRequest) {
        if (CategoryEnum.hasDescription(productRequest.category()))
            return productRepositoryPort.updateProduct(productId, productRequest);
        else
            throw new ProductException("Category does not exist, inform the 'LANCHE', 'ACOMPANHAMENTO', 'SOBREMESA' and 'BEBIDA' type categories");
    }

    @Override
    public List<ProductResponse> getProductByCategory(String category) {
        if (CategoryEnum.hasDescription(category))
            return productRepositoryPort.getProductByCategory(category.toUpperCase());
        else
            throw new ProductException("Category does not exist");
    }

    @Override
    public void deleteProduct(String productId) {
        productRepositoryPort.deleteProduct(productId);
    }
}
