package com.fiapfood.product.application.core.domain;

public enum CategoryEnum {

    LANCHE("1", "Lanche"),
    ACOMPANHAMENTO("2", "Acompanhamento"),
    SOBREMESA("3", "Sobremesa"),
    BEBIDA("4", "Bebida");

    private String code;
    private String description;

    CategoryEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static boolean hasDescription(String description) {
        for (CategoryEnum category : CategoryEnum.values()) {
            if (category.getDescription().equalsIgnoreCase(description)) {
                return true;
            }
        }
        return false;
    }
}
