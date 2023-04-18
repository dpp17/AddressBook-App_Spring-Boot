package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.interfaces.IContactBusinessLogics;
import com.bridgelabz.addressbook.model.ContactData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactBusinessLogics implements IContactBusinessLogics {

    List<ContactData> contactDataList = new ArrayList<ContactData>();
    @Override
    public String addContact(ContactDTO contactDTO) {
        ContactData contactData = new ContactData(contactDTO);
        contactDataList.add(contactData);
        return "Saved";
    }

    @Override
    public String getContactByID(int id) {
        List<ContactData> list = contactDataList.stream().filter(data->data.getContact_id() == id).collect(Collectors.toList());
        return list.toString();
    }

    @Override
    public String getAllContact() {
        return contactDataList.toString();
    }

    @Override
    public String deleteContactByID(int id) {
        contactDataList.remove(id);
        return "deleted with ID :: " + id;
    }

    @Override
    public String deleteAllContact() {
        contactDataList = null;
        return "All Contact Deleted";
    }

    @Override
    public String updateContactDetailsByID(int id) {
        return null;
    }
}
