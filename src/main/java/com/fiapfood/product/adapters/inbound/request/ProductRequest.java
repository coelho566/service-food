package com.fiapfood.product.adapters.inbound.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ProductRequest(

         String name,
         String description,
         String category,
         BigDecimal price,
         String image,
         String availability,
         List<String>ingredients,
         String breadType,
         String dessertType,
         String beverageType,
         String portionSize,
         double weight,
         int calories,
         int volume
) { }
