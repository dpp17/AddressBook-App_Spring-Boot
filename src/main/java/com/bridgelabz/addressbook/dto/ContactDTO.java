package com.bridgelabz.addressbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

@ToString
public class ContactDTO {

    @NotBlank(message = "FirstName Cannot be empty")
    @Pattern(regexp = "^[A-Z][A-Za-z]{2,}$", message = "Start FirstName With Capital Letter")
    public String firstName;

    @NotBlank(message = "LastName Cannot be empty")
    @Pattern(regexp = "^[A-Z][A-Za-z]{2,}$", message = "Start LastName With Capital Letter")
    public String lastName;

    @NotBlank(message = "Address Cannot be empty")
    @Pattern(regexp = "^[^@#$%^&*]+$", message = "Special Character can't be used")
    public String address;

    public String city;

    @NotBlank(message = "State Cannot be empty")
    public String state;

    @NotNull(message = "Email ID Cannot be empty")
    @Pattern(regexp = "^[a-z_0-9]{2,}@gmail.com$", message = "give email in format :: xxxxxxxx@gmail.com")
    public String email;

    @NotNull(message = "Zip Code Cannot be empty")
    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Zip Code must be of 6 digits")
    public String zip;

    @NotNull(message = "PhoneNumber Cannot be empty")
    @Pattern(regexp = "^[6789][0-9]{9}$", message = "PhoneNumber must be of 10 digits and in format of 9xxxxxxxxx or 8xxxxxxxxx or 7xxxxxxxxx or 6xxxxxxxxx only")
    public String phoneNumber;

    @NotNull(message = "Aadhar Card Number Cannot be empty")
    @Pattern(regexp = "^[1-9][0-9]{15}$", message = "Aadhar Card Number must be of 16 digits start with non-zero digit")
    public String aadharCardNumber;
}
