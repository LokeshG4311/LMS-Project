package com.lms.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.backend.model.User;
import com.lms.backend.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("Signup Successful");
    }

    //@PostMapping("/login")
    //public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
    //    String email = credentials.get("email");
     //   String password = credentials.get("password");

    //    User user = userService.login(email, password);
    //    if (user != null) {
     //       return ResponseEntity.ok("Login Successful");
    //    } else {
    //        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    //    }
    //}
}
