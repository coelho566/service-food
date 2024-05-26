package com.fiapfood.product.adapters.outbound;

import com.fiapfood.product.adapters.inbound.entity.ProductEntity;
import com.fiapfood.product.adapters.inbound.mapper.ProductMapper;
import com.fiapfood.product.adapters.inbound.response.ProductResponse;
import com.fiapfood.product.adapters.outbound.repository.ProductRepository;
import com.fiapfood.product.application.core.domain.Product;
import com.fiapfood.product.application.core.exception.ProductException;
import com.fiapfood.product.application.ports.out.ProductRepositoryPort;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class ProductRepositoryAdapter implements ProductRepositoryPort {


    ProductRepository productRepository;
    ProductMapper productMapper;

    public ProductRepositoryAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public void insertProduct(Product product) {

        var productByNome = productRepository.getProductByNome(product.name());
        if (productByNome.isEmpty()) {
            productRepository.persist(productMapper.productToProductEntity(product));
        } else {
            throw new ProductException("Product already exists with the name provided");
        }
    }

    @Override
    public ProductResponse updateProduct(String productId, Product product) {

        Optional<ProductEntity> byIdOptional = productRepository.findByIdOptional(new ObjectId(productId));
        if (byIdOptional.isPresent()) {
            var productByNome = productRepository.getProductByNome(product.name());
            if (productByNome.isEmpty() || productByNome.get().getId().equals(new ObjectId(productId))) {
                var newProduct = productMapper.productToProductEntity(product);
                newProduct.setId(new ObjectId(productId));
                productRepository.persistOrUpdate(newProduct);
                return productMapper.productEntityToProductResponse(newProduct);
            } else {
                throw new ProductException("Product already exists with the name provided");
            }
        } else {
            throw new ProductException("Product not found for update");
        }
    }

    @Override
    public void deleteProduct(String productId) {
        productRepository.deleteById(new ObjectId(productId));
    }

    @Override
    public List<ProductResponse> getProductByCategory(String category) {
        var productByCategory = productRepository.getProductByCategory(category);
        if (!productByCategory.isEmpty()){
            return productByCategory.stream()
                    .map(product -> productMapper.productEntityToProductResponse(product)).collect(Collectors.toList());
        }else{
            throw new ProductException("Product not found for the specified category");
        }
    }
}
