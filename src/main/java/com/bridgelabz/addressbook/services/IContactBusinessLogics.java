package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.ContactData;

import java.util.List;

public interface IContactBusinessLogics {

    ResponseDTO addContact(ContactDTO contactDTO);

    String getContactByToken(String userToken);

    List<ContactData> getAllContact();

    String deleteContactByToken(String userToken);

    String deleteAllContact();

    String updateContactDetailsByToken(ContactDTO contactData , String userToken);

}
