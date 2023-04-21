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
        emailService.sendEmail(contactDTO.getEmail(),"Data Added Successfully",
                "Hey..."+contactData.getFirstName()+"\n You have been successfully added the data.\n\n"+contactData);
        return new ResponseDTO(token,contactData);
    }

    @Override
    public String getContactByToken(String userToken) {
        int id = jwtToken.decodeToken(userToken);
       ContactData contact = contactRepo.findById(id).orElseThrow(()->new AddressBookIDNotFoundException("Employee not Found with ID:: " + id));
       return contact.toString();
    }

    @Override
    public String getAllContact() {
        List<ContactData> contact = contactRepo.findAll();
        return contact.toString();
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
    public String updateContactDetailsByToken(ContactData contactData ,String Token) {
        int id = jwtToken.decodeToken(Token);
        ContactData contact = contactRepo.findById(id).orElseThrow(()->new AddressBookIDNotFoundException("Employee not Found with ID:: " + id));


        contact.setFirstName(contactData.getFirstName());
        contact.setLastName(contactData.getLastName());
        contact.setAddress(contactData.getAddress());
        contact.setCity(contactData.getCity());
        contact.setState(contactData.getState());
        contact.setZip(contactData.getZip());
        contact.setEmail(contactData.getEmail());
        contact.setPhoneNumber(contactData.getPhoneNumber());
        contact.setAadharCardNumber(contactData.getAadharCardNumber());

            contactRepo.save(contact);
            log.debug("Contact edited with ID :: " + id);
            log.info("Contact saved in DB" + contact.toString());
            return "Employee Details Edited Successfully...." + contact.toString();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                               :: Address Book - Registtration ::                                   //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public ResponseDTO registerUser(ContactDTO contactDTO) {
        Random random = new Random();
        registerContact = new ContactData(contactDTO);
        otp = (random.nextInt(9000)+999);
//        int num =(int) Math.random();
        emailService.sendEmail(contactDTO.getEmail(),"Verify Your Account",
                "Hey... "+(registerContact.getFirstName()+" "+registerContact.getLastName())+"\n\n YOUR OTP IS :: "+otp);
        return new ResponseDTO("Information",registerContact);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                               :: Address Book - Verify Account ::                                   //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String verifyAccount(int OTP) {
        if(otp==OTP){
            ContactData userData = contactRepo.save(registerContact);

            String token =jwtToken.createToken(registerContact.getContact_id());
            emailService.sendEmail(registerContact.getEmail(),"Account verified successful",
                    "Hey... "+(registerContact.getFirstName()+" "+registerContact.getLastName())+"\n\n Account verified successful "+
                            "\n\n"+"********** Your UserName is :=>"+registerContact.getUserName() +
                            "\n\n"+"********** Your Id is :=>"+userData.getContact_id()+
                            "**********\n Your Email ID : "+registerContact.getEmail()+"\n Mobile Number : "+registerContact.getPhoneNumber());
            otp=89899898;
            registerContact=null;
            return "Account Register successfully \n Token :"+token;
        }

        return "Invalid OTP";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                               :: Address Book - User Login ::                                   //
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String loginUser(int id,String userName,String password) {
        ContactData userData = contactRepo.findById(id).orElseThrow(()->new AddressBookIDNotFoundException("Employee not Found with ID:: " + id));
            if((userData.getUserName()).equals(userName)){
                if((userData.getPassword()).equals(password)){
                    return "^^^^^^^^^^^^^^^^^"+"\n Login successfully"+'\n'+"^^^^^^^^^^^^^^^^^";
                }else{
                    return "!!!!!!!!!!!! Invalid Password!!!!!!!!!!!!!!!";
                }

            }else{
                return "!!!!!!!!!!!! Invalid User Name!!!!!!!!!!!!!!";
            }
    }

}
