package com.test.applicaiton.controller;

import com.test.applicaiton.service.UserService;
import dto.UserDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/greet")
    public String greetMe() {
        return "Hi Ashutosh";
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
    }

    @GetMapping("/allUsers")
    public List<UserDTO> fetchUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/users")
    public List<UserDTO> fetchUserByUserName(@PathParam("userName") String userName) {
        return userService.fetchUserByUserName(userName);
    }

}
