package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactData {

    private int contact_id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String email;
    private int zip;
    private String phoneNumber;
    private long aadharCardNumber;

    public ContactData(ContactDTO contactDTO) {
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.email = contactDTO.email;
        this.zip = contactDTO.zip;
        this.phoneNumber = contactDTO.phoneNumber;
        this.aadharCardNumber = contactDTO.aadharCardNumber;
    }
}
