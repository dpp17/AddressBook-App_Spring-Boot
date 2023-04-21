package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.ContactData;

public interface IContactBusinessLogics {

    ResponseDTO addContact(ContactDTO contactDTO);

    String getContactByToken(String userToken);

    String getAllContact();

    String deleteContactByToken(String userToken);

    String deleteAllContact();

    String updateContactDetailsByToken(ContactData contactData , String userToken);

    public ResponseDTO registerUser(ContactDTO contactDTO);

    public String verifyAccount(int OTP);

    public String loginUser(int id,String userName,String password);
}
