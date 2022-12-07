package com.test.application.controller;

import com.test.application.service.UserService;
import dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @Operation(summary = "Add User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API to add user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = void.class))}),
            @ApiResponse(responseCode = "601", description = "Invalid Input",
                    content = @Content),
            @ApiResponse(responseCode = "602", description = "Unable to save the User Data",
                    content = @Content),
            @ApiResponse(responseCode = "603", description = "Something went wrong",
                    content = @Content)
    })
    @PostMapping("/addUser")
    public void addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
    }

    @Operation(summary = "Fetch all Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All users have been fetched",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "603", description = "Failed to fetch all users",
                    content = @Content)
    })
    @GetMapping("/allUsers")
    public List<UserDTO> fetchUsers() {
        return userService.fetchAllUsers();
    }

    @Operation(summary = "Fetch all Users by user name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users have been fetched",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "601", description = "Invalid Input",
                    content = @Content),
            @ApiResponse(responseCode = "602", description = "No Data Found",
                    content = @Content)
    })
    @GetMapping("/userByName")
    public List<UserDTO> fetchUserByUserName(@PathParam("userName") String userName) {
        return userService.fetchUserByUserName(userName);
    }

}
