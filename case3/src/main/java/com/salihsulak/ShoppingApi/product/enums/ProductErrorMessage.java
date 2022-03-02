package com.salihsulak.ShoppingApi.product.enums;

import com.salihsulak.ShoppingApi.generic.enums.BaseErrorMessage;

public enum ProductErrorMessage implements BaseErrorMessage {
    PRODUCT_NOT_FOUND("Product not found!"),
    PRODUCT_SAVE_FAIL("Product save failed")
    ;

    private final String message;

    ProductErrorMessage(String message) {
    this.message=message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
