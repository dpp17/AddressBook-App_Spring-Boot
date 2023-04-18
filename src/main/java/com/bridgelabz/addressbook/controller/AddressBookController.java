package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ContactDTO;
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

    private List<ContactData> contactList = new ArrayList<>();
    @PostMapping("/save")
    public ResponseEntity<String> saveContact(ContactDTO contactDTO){
        ContactData contactData= new ContactData(contactDTO);
        contactList.add(contactData);
        return new ResponseEntity<>("Data Saved Successfully :: "+contactData.getFirstName() +" : "+contactData.getPhoneNumber(), HttpStatus.CREATED);
    }

    @GetMapping("/getContact/{id}")
    public String getContactByID(@PathVariable int id){
        return "Requested Data :: " + contactList.get(id);
    }

    @GetMapping("/getAllContact")
    public String getAllContact(){
        return contactList.toString();
    }

    @DeleteMapping("/deleteContact/{id}")
    public String deleteContactByID(@PathVariable int id){
        return "delete " + id;
    }

    @DeleteMapping("/deleteAllContact")
    public String deleteAllContact(){
        contactList = null;
        return "Contacts deleted";
    }

    @PutMapping("/editContact/{id}")
    public String updateContactByID(@PathVariable int id){
        return "edited";
    }
}
