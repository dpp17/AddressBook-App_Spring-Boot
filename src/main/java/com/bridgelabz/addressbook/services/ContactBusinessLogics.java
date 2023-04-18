package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.interfaces.IContactBusinessLogics;
import org.springframework.stereotype.Service;

@Service
public class ContactBusinessLogics implements IContactBusinessLogics {

    @Override
    public String addContact(ContactDTO contactDTO) {
        return null;
    }

    @Override
    public String getContactByID(int id) {
        return null;
    }

    @Override
    public String getAllContact() {
        return null;
    }

    @Override
    public String deleteContactByID(int id) {
        return null;
    }

    @Override
    public String deleteAllContact() {
        return null;
    }

    @Override
    public String updateContactDetailsByID(int id) {
        return null;
    }
}
