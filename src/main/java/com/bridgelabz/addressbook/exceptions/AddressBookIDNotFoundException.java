package com.bridgelabz.addressbook.exceptions;

public class AddressBookIDNotFoundException extends RuntimeException{
    public AddressBookIDNotFoundException(String message) {
        super(message);
    }
}
