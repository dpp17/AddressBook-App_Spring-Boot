package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.services.IContactBusinessLogics;
import com.bridgelabz.addressbook.model.ContactData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

        @Autowired
        private IContactBusinessLogics iServices;

    @PostMapping("/save")
    public ResponseDTO saveContact( @RequestBody ContactDTO contactDTO){
        return  iServices.addContact(contactDTO);
    }

    @GetMapping("/getContact/{userToken}")
    public String getContactByID(@PathVariable String userToken){
        return iServices.getContactByToken(userToken);
    }

    @GetMapping("/getAllContact")
    public List<ContactData> getAllContact(){
        return iServices.getAllContact();
    }

    @DeleteMapping("/deleteContact/{userToken}")
    public String deleteContactByID(@PathVariable  String userToken){
        return iServices.deleteContactByToken(userToken);
    }

    @DeleteMapping("/deleteAllContact")
    public String deleteAllContact(){
        return iServices.deleteAllContact();
    }

    @PutMapping("/editContact/{userToken}")
    public String updateContactByID(@Valid @RequestBody ContactDTO contactDTO, @PathVariable String userToken){
//        ContactData contactData = new ContactData(contactDTO);
        return iServices.updateContactDetailsByToken(contactDTO, userToken);
    }

}
