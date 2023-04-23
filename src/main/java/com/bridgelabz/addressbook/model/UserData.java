package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "UserData")
@Data
@NoArgsConstructor
public class UserData {

    @Id
    @GeneratedValue
    private int userId;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private int otp;
    private boolean verify;

    public UserData(UserDTO userDTO) {
        this.userName = userDTO.getUserName();
        this.email = userDTO.getEmail();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.password = userDTO.getPassword();
    }
}
