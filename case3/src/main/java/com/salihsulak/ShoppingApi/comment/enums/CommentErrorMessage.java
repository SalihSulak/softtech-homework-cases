package com.salihsulak.ShoppingApi.comment.enums;

import com.salihsulak.ShoppingApi.generic.enums.BaseErrorMessage;

public enum CommentErrorMessage implements BaseErrorMessage {

    FILL_JUST_ONE_INPUT("Please fill just one input!"),
    NOT_FOUND("Comment not found"),
    SAVE_FAILED("Save comment failed");
    private String message;

    CommentErrorMessage(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
