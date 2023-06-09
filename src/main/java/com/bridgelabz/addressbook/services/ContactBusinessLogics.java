package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.exceptions.AddressBookIDNotFoundException;
import com.bridgelabz.addressbook.model.ContactData;
import com.bridgelabz.addressbook.repository.ContactRepo;
import com.bridgelabz.addressbook.utility.EmailServices;
import com.bridgelabz.addressbook.utility.JWTToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class ContactBusinessLogics implements IContactBusinessLogics {
    private int otp;
    private ContactData registerContact;
    @Autowired
    private ContactRepo contactRepo;
    @Autowired
    private EmailServices emailService;
    @Autowired
    private JWTToken jwtToken;

    @Override
    public ResponseDTO addContact(ContactDTO contactDTO) {
        ContactData contactData = new ContactData(contactDTO);
        contactRepo.save(contactData);
        log.info("Contact added to DB:: " + contactData.toString());
//        ResponseDTO responseDTO = new ResponseDTO("Contact Saved SuccessFully", contactData);
        String token = jwtToken.createToken(contactData.getContact_id());
//        emailService.sendEmail(contactDTO.getEmail(),"Data Added Successfully",
//                "Hey..."+contactData.getFirstName()+"\n You have been successfully added the data.\n\n"+contactData);
        return new ResponseDTO(token,contactData);
    }

    @Override
    public String getContactByToken(String userToken) {
        int id = jwtToken.decodeToken(userToken);
       ContactData contact = contactRepo.findById(id).orElseThrow(()->new AddressBookIDNotFoundException("Employee not Found with ID:: " + id));
       return contact.toString();
    }

    @Override
    public List<ContactData> getAllContact() {
        return contactRepo.findAll();
    }

    @Override
    public String deleteContactByToken(String userToken) {
        int id = jwtToken.decodeToken(userToken);
        ContactData contact = contactRepo.findById(id).orElseThrow(()->new AddressBookIDNotFoundException("Employee not Found with ID:: " + id));
        contactRepo.deleteById(id);
            log.warn("Contact deleted from DB:: " + contact.toString());
            return "deleted with ID :: " + id;
    }

    @Override
    public String deleteAllContact() {
        contactRepo.deleteAll();
        log.warn("All Contact Deleted from DB");
        return "All Contact Deleted";
    }

    @Override
    public String updateContactDetailsByToken(ContactDTO contactData ,String Token) {
        int id = jwtToken.decodeToken(Token);
        ContactData contact = contactRepo.findById(id).orElseThrow(()->new AddressBookIDNotFoundException("Employee not Found with ID:: " + id));


        contact.updateContactData(contactData);

            contactRepo.save(contact);
            log.debug("Contact edited with ID :: " + id);
            log.info("Contact saved in DB" + contact.toString());
            return "Employee Details Edited Successfully...." + contact.toString();
    }

}
//==>> get user by id //