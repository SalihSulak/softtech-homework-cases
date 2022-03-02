package com.salihsulak.ShoppingApi.user.enums;

import com.salihsulak.ShoppingApi.generic.enums.BaseErrorMessage;

public enum UserErrorMessage implements BaseErrorMessage {
    USER_NOT_FOUND("User Not Found"),
    USER_SAVE_FAIL("User Save Failed!"),
    ;

    private final String message;
    UserErrorMessage(String message) {
        this.message = message;

    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
