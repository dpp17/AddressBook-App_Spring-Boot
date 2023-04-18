package com.bridgelabz.addressbook.interfaces;

import com.bridgelabz.addressbook.dto.ContactDTO;

public interface IContactBusinessLogics {

    String addContact(ContactDTO contactDTO);

    String getContactByID(int id);

    String getAllContact();

    String deleteContactByID(int id);

    String deleteAllContact();

    String updateContactDetailsByID(int id);
}
