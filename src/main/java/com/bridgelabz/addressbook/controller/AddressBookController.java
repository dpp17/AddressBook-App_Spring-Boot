package com.bridgelabz.addressbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ab")
public class AddressBookController {

    @PostMapping("/save")
    public ResponseEntity<String> saveContact(@RequestParam String firstName, @RequestParam String mobileNumber){
        return new ResponseEntity<>("Data Saved Successfully :: "+firstName +" : "+mobileNumber, HttpStatus.CREATED);
    }

    @GetMapping("/getContact/{id}")
    public String getContactByID(@PathVariable int id){
        return "id :: " + id;
    }

    @GetMapping("/getAllContact")
    public String getAllContact(){
        return "All Contact";
    }

    @DeleteMapping("/deleteContact/{id}")
    public String deleteContactByID(@PathVariable int id){
        return "delete " + id;
    }

    @DeleteMapping("/deleteAllContact")
    public String deleteAllContact(){
        return "delete All Contacts";
    }

    @PutMapping("/editContact/{id}")
    public String updateContactByID(@PathVariable int id){
        return "edited";
    }
}
