package com.salihsulak.ShoppingApi.comment.exception;

public class UserHasNotCommented extends RuntimeException{
    public UserHasNotCommented(String username){
        super("User " + username + " has not comment yet");
    }
}
