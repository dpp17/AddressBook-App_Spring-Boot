package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.ContactDTO;

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

    public ContactData() {
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getAadharCardNumber() {
        return aadharCardNumber;
    }

    public void setAadharCardNumber(long aadharCardNumber) {
        this.aadharCardNumber = aadharCardNumber;
    }

    @Override
    public String toString() {
        return  "contact_id= " + contact_id +
                "FirstName= " + firstName +
                "LastName= " + lastName +
                "Address= " + address +
                "City= " + city +
                "State= " + state +
                "Email= '" + email +
                "Zip= " + zip +
                "Phone Number= " + phoneNumber +
                "Aadhar Card Number= " + aadharCardNumber;
    }
}
