package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.ContactData;

public interface IContactBusinessLogics {

    ResponseDTO addContact(ContactDTO contactDTO);

    String getContactByID(int id);

    String getAllContact();

    String deleteContactByID(int id);

    String deleteAllContact();

    String updateContactDetailsByID(ContactData contactData , int id);
}