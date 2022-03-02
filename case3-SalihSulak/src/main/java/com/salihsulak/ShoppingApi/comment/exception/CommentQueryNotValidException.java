package com.salihsulak.ShoppingApi.comment.exception;

public class CommentQueryNotValidException extends IllegalArgumentException{
    public CommentQueryNotValidException(){
        super("Comment Query Not Valid");
    }
}
