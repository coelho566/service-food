package com.fiapfood.product.application.ports.out;

import com.fiapfood.product.adapters.inbound.response.ProductResponse;
import com.fiapfood.product.application.core.domain.Product;

import java.util.List;

public interface ProductRepositoryPort {

   void insertProduct(Product product);
   ProductResponse updateProduct(String productId, Product product);
   void deleteProduct(String productId);
   List<ProductResponse> getProductByCategory(String category);
}
