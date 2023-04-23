package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.dto.UserDTO;

public interface IUserBusinessLogics {

    public ResponseDTO registerUser(UserDTO userDTO);

    public String verifyAccount(String email, int otp);

    public String loginUser(String email,String password);

    String getForgottenPassword(String email);

    String resetPassword(String email, String password, String confirmPassword);

    ResponseDTO updateByEmail(UserDTO userDTO);

    ResponseDTO getUserByEmailId(String email);

    String deleteUserByEmailId(String email);
}
