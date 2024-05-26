package com.fiapfood.product.application.ports.in;

import com.fiapfood.product.adapters.inbound.response.ProductResponse;
import com.fiapfood.product.application.core.domain.Product;

import java.util.List;

public interface ProductUseCasePort {
    void insertProduct(Product productRequest);

    ProductResponse updateProduct(String productId, Product productRequest);

    List<ProductResponse> getProductByCategory(String category);

    void deleteProduct(String productId);
}
