package com.bridgelabz.addressbook.exceptions;

public class UserIDNotFoundException extends RuntimeException{
    public UserIDNotFoundException(String message) {
        super(message);
    }
}
