package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.ContactData;
import com.bridgelabz.addressbook.repository.ContactRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContactBusinessLogics implements IContactBusinessLogics {
    @Autowired
    private ContactRepo contactRepo;

    @Override
    public ResponseDTO addContact(ContactDTO contactDTO) {
        ContactData contactData = new ContactData(contactDTO);
        contactRepo.save(contactData);
        log.info("Contact added to DB:: " + contactData.toString());
        ResponseDTO responseDTO = new ResponseDTO("Contact Saved SuccessFully", contactData);
        return responseDTO;
    }

    @Override
    public String getContactByID(int id) {
       Optional<ContactData> contact = contactRepo.findById(id);
       return contact.toString();
    }

    @Override
    public String getAllContact() {
        List<ContactData> contact = contactRepo.findAll();
        return contact.toString();
    }

    @Override
    public String deleteContactByID(int id) {
        Optional<ContactData> contact = contactRepo.findById(id);
        if(contact.isPresent()){
        contactRepo.deleteById(id);
            log.warn("Contact deleted from DB:: " + contact.toString());
            return "deleted with ID :: " + id;
        }else return "Contact with ID :: "+ id +" not found";
    }

    @Override
    public String deleteAllContact() {
        contactRepo.deleteAll();
        log.warn("All Contact Deleted from DB");
        return "All Contact Deleted";
    }

    @Override
    public String updateContactDetailsByID(ContactData contactData ,int id) {
        Optional<ContactData> contact = contactRepo.findById(id);

        if(contact.isPresent()) {
            contact.get().setFirstName(contactData.getFirstName());
            contact.get().setLastName(contactData.getLastName());
            contact.get().setAddress(contactData.getAddress());
            contact.get().setCity(contactData.getCity());
            contact.get().setState(contactData.getState());
            contact.get().setZip(contactData.getZip());
            contact.get().setEmail(contactData.getEmail());
            contact.get().setPhoneNumber(contactData.getPhoneNumber());
            contact.get().setAadharCardNumber(contactData.getAadharCardNumber());

            contactRepo.save(contact.get());
            log.debug("Contact edited with ID :: " + id);
            log.info("Contact saved in DB" + contact.toString());
            return "Employee Details Edited Successfully...." + contact.toString();
        }else return"Contact with ID :: "+ id +" not found";
    }

}
