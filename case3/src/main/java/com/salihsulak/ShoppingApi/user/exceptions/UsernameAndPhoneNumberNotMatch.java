package com.salihsulak.ShoppingApi.user.exceptions;

public class UsernameAndPhoneNumberNotMatch extends RuntimeException{
    public UsernameAndPhoneNumberNotMatch(String username, String phoneNumber){
        super("Username "+username+" and "+phoneNumber+" phone number doesn't match");
    }
}
