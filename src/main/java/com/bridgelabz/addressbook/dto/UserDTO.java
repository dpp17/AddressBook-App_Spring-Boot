package com.bridgelabz.addressbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "UserName Cannot be empty")
    @Pattern(regexp = "^[a-zA-Z_0-9]{1,}[@$&]{1}[0-9]{4}$", message = "userName must be in format : xxxx@1234")
    public String userName;

    @NotBlank(message = "UserName Cannot be empty")
    @Pattern(regexp = "^[a-zA-Z_0-9]{1,}[!@#$%^&*][a-zA-Z_0-9]{1,}$", message = "password must have 1 Special Character")
    public String password;

    @NotNull(message = "Email ID Cannot be empty")
    @Pattern(regexp = "^[a-z_0-9]{2,}@gmail.com$", message = "give email in format :: xxxxxxxx@gmail.com")
    public String email;

    @NotNull(message = "PhoneNumber Cannot be empty")
    @Pattern(regexp = "^[6789][0-9]{9}$", message = "PhoneNumber must be of 10 digits and in format of 9xxxxxxxxx or 8xxxxxxxxx or 7xxxxxxxxx or 6xxxxxxxxx only")
    public String phoneNumber;


}
