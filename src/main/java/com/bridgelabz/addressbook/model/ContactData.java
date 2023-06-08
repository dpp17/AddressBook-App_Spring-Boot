package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.ContactDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ContactData {

    @Id
    @GeneratedValue
    private int contact_id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String email;
    private String zip;
    private String phoneNumber;


    public void updateContactData(ContactDTO contactDTO) {
        this.firstName = contactDTO.getFirstName();
        this.lastName = contactDTO.getLastName();
        this.address = contactDTO.getAddress();
        this.city = contactDTO.getCity();
        this.state = contactDTO.getState();
        this.email = contactDTO.getEmail();
        this.zip = contactDTO.getZip();
        this.phoneNumber = contactDTO.getPhoneNumber();
    }
    public ContactData(ContactDTO contactDTO) {
        this.updateContactData(contactDTO);
    }
}
