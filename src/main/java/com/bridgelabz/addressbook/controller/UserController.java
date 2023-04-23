package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.*;
import com.bridgelabz.addressbook.services.IUserBusinessLogics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userBook")
public class UserController {

    @Autowired
    private IUserBusinessLogics iUserServices;

    @PostMapping("/register")
    public ResponseDTO registerUser(@RequestBody UserDTO userDTO){
        return iUserServices.registerUser(userDTO);
    }
    @PutMapping("/verify")
    public String verifyUser(@RequestBody VerifyDTO verifyDTO){
        return iUserServices.verifyAccount(verifyDTO.email, verifyDTO.otp);
    }

    @GetMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO){
        return iUserServices.loginUser(loginDTO.getEmail(),loginDTO.getPassword());
    }

    @PutMapping("/forgot")
    public String forgotPassword(@RequestBody ForgotResetDTO forgotResetDTO){
        return iUserServices.getForgottenPassword(forgotResetDTO.getEmail());
    }

    @PutMapping("/reset")
    public String resetPassword(@RequestBody ForgotResetDTO forgotResetDTO){
        return iUserServices.resetPassword(forgotResetDTO.getEmail(), forgotResetDTO.getPassword(), forgotResetDTO.getConfirmPassword());
    }

    @PutMapping("/updateUser")
    public ResponseDTO updateByEmail(@RequestBody UserDTO userDTO){
        return iUserServices.updateByEmail(userDTO);
    }

    @GetMapping("/getUser")
    public ResponseDTO getUserByEmailId(@RequestBody UserDTO userDTO){
        return iUserServices.getUserByEmailId(userDTO.email);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUserByEmailId(@RequestBody UserDTO userDTO){
        return iUserServices.deleteUserByEmailId(userDTO.email);
    }

}
