package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.interfaces.IContactBusinessLogics;
import com.bridgelabz.addressbook.model.ContactData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ab")
public class AddressBookController {

    @Autowired
    private IContactBusinessLogics iServices;

    @PostMapping("/save")
    public String saveContact(ContactDTO contactDTO){
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
    public String updateContactByID(@PathVariable int id){
        return iServices.updateContactDetailsByID(id);
    }
}
