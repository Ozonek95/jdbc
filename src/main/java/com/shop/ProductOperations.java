package com.shop;

public enum ProductOperations {
    DELETE(new ProductDelete()),UPDATE(new ProductUpdate()),INSERT(new ProductInsert()),
    SHOW_ONE(new ProductShowOne()),SHOW_ALL(new ProductShowAll());

    private ProductOperation operation;

    ProductOperations(ProductOperation operation) {
        this.operation = operation;
    }

    public ProductOperation getOperation() {
        return operation;
    }
}
