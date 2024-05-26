package com.fiapfood.product.application.core.domain;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record Product(
        @Schema(description = "The name of the product", example = "Cheeseburger")
        String name,

        @Schema(description = "The description of the product", example = "Um delicioso cheeseburger com todos os acompanhamentos.")
        String description,

        @Schema(description = "The category of the product", example = "LANCHE")
        CategoryEnum category,

        @Schema(description = "The price of the product", example = "9.99")
        Double price,

        @Schema(description = "The image URL of the product", example = "http://example.com/cheeseburger.jpg")
        String image,

        @Schema(description = "The availability status of the product", example = "true")
        Boolean availability,
        @Schema(description = "The list of ingredients of the product", example = "[\"Hanburguer\", \"Queijo\", \"Alface\"]")
        List<String> ingredients,

        @Schema(description = "The type of bread used for the product", example = "Pão de hambúrguer")
        String breadType,

        @Schema(description = "The type of dessert, if applicable", example = "Sorvete de Chocolate")
        String dessertType,

        @Schema(description = "The type of beverage, if applicable", example = "Coca Cola")
        String beverageType,

        @Schema(description = "The portion size of the product", example = "Média")
        String portionSize,

        @Schema(description = "The weight of the product in grams", example = "250.0")
        double weight,

        @Schema(description = "The number of calories in the product", example = "700")
        int calories,

        @Schema(description = "The volume of the product in milliliters", example = "500")
        int volume
) {
}
