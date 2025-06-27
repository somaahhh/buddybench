package com.buddybench.controller;

import com.buddybench.entity.Users;
import com.buddybench.service.UsersService;
import com.buddybench.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsersController {


    @Autowired
    private UsersService usersService;


    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@ModelAttribute Users users) {
        System.out.println("User details: " + users.toString());
        if (!users.getPassword().equals(users.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Passwords do not match");
        }
        Users savedUser = usersService.saveUsersDetails(users);
        return ResponseEntity.ok(savedUser);
    }


    @GetMapping("/get-users")
    public ResponseEntity<?> getUsers() {
        List<Users> userData = usersService.getUsersDetails();
        return userData.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constants.recordNotFound)
                : ResponseEntity.ok(userData);
    }

    // get single record

    @GetMapping("/getUserByEmail")
    public ResponseEntity<?> getUsersById(@ModelAttribute Users users) {
        Optional<Users> userData = usersService.findByEmailId(users.getEmailId());
        return userData.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constants.recordNotFound)
                : ResponseEntity.ok(userData);
    }

    // update user details

    // deletee users details

    // deactivate users details

    // active users details

    // verify user account


}