package com.craft.Techie.controllers;

import com.craft.Techie.dao.PostDAO;
import com.craft.Techie.dao.UserDAO;
import com.craft.Techie.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDAO> getUserById(@PathVariable("id") int userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
    }

    @PostMapping("/addUser/")
    public ResponseEntity<UserDAO> addUser(@RequestBody UserDAO userDAO){
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(userDAO));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(userId));
    }

    @PutMapping
    public ResponseEntity<Boolean> modifyUser(@RequestBody UserDAO userDAO){
        return ResponseEntity.status(HttpStatus.OK).body(userService.modifyUser(userDAO));
    }

}
