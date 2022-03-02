package com.salihsulak.ShoppingApi.comment.exception;

public class ProductHasNotCommented extends RuntimeException{
    public ProductHasNotCommented(String productName){
        super("Product " + productName +" has not comment yet");
    }
}
