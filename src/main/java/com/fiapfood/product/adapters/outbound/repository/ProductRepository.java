package com.fiapfood.product.adapters.outbound.repository;

import com.fiapfood.product.adapters.inbound.entity.ProductEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductRepository implements PanacheMongoRepository<ProductEntity> {

    public List<ProductEntity> getProductByCategory(String category) {
        return find("category", category).list();
    }

    public Optional<ProductEntity> getProductByNome(String name) {
        return find("name", name).firstResultOptional();
    }
}
