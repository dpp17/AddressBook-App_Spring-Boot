package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.services.IContactBusinessLogics;
import com.bridgelabz.addressbook.model.ContactData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ab")
public class AddressBookController {

    @Autowired
    private IContactBusinessLogics iServices;

    @PostMapping("/save")
    public ResponseDTO saveContact(@Valid @RequestBody ContactDTO contactDTO){
        return  iServices.addContact(contactDTO);
    }

    @GetMapping("/getContact/{id}")
    public String getContactByID(@PathVariable int id){
        return iServices.getContactByID(id);
    }

    @GetMapping("/getAllContact")
    public String getAllContact(){
        return iServices.getAllContact();
    }

    @DeleteMapping("/deleteContact/{id}")
    public String deleteContactByID(@PathVariable int id){
        return iServices.deleteContactByID(id);
    }

    @DeleteMapping("/deleteAllContact")
    public String deleteAllContact(){
        return iServices.deleteAllContact();
    }

    @PutMapping("/editContact/{id}")
    public String updateContactByID(@Valid @RequestBody ContactDTO contactDTO, @PathVariable int id){
        ContactData contactData = new ContactData(contactDTO);
        return iServices.updateContactDetailsByID(contactData, id);
    }
}
