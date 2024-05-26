package com.fiapfood.product.adapters.inbound.mapper;

import com.fiapfood.product.adapters.inbound.entity.ProductEntity;
import com.fiapfood.product.adapters.inbound.response.ProductResponse;
import com.fiapfood.product.application.core.domain.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;

@ApplicationScoped
public class ProductMapper {


    public ProductEntity productToProductEntity(Product product) {
        return ProductEntity.builder()
                .name(product.name())
                .description(product.description())
                .category(product.category().getDescription())
                .price(product.price())
                .image(product.image())
                .availability(product.availability())
                .registrationDate(LocalDateTime.now())
                .ingredients(product.ingredients())
                .breadType(product.breadType())
                .dessertType(product.dessertType())
                .beverageType(product.beverageType())
                .portionSize(product.portionSize())
                .weight(product.weight())
                .calories(product.calories())
                .volume(product.volume())
                .build();
    }

    public ProductResponse productEntityToProductResponse(ProductEntity product) {
        return new ProductResponse(product.getId().toString(),product.getName(), product.getDescription(), product.getCategory(), product.getPrice(),
                product.getImage(), product.getAvailability(), product.getRegistrationDate(), product.getIngredients(), product.getBreadType(), product.getDessertType(),
                product.getBeverageType(), product.getPortionSize(),product.getWeight(), product.getCalories(), product.getVolume());
    }
}
