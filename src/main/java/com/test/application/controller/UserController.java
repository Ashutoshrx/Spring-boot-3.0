package com.test.application.controller;

import com.test.application.service.UserService;
import dto.PaginationSortRequestDTO;
import dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

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
    public void addUser(@RequestBody @NotNull UserDTO userDTO) {
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
    @GetMapping("/findByUserName")
    public List<UserDTO> fetchUserByUserName(@PathParam("userName") String userName) {
        return userService.fetchUserByUserName(userName);
    }

    @GetMapping("/findUsersWithPagination")
        public Page<UserDTO> fetchUsersWithPaginationAndSorting(@RequestBody PaginationSortRequestDTO paginationSortRequestDTO){
        return userService.fetchUsersWithPaginationAndSorting(paginationSortRequestDTO);
        }
    @GetMapping("/")
    public String checkLogs() {
        LOGGER.trace("A TRACE Message");
        LOGGER.debug("A DEBUG Message");
        LOGGER.info("An INFO Message");
        LOGGER.warn("A WARN Message");
        LOGGER.error("An ERROR Message");

        return "Check your logs";
    }
/*Use of base xml
    https://medium.com/@nikitashahu/logging-in-spring-boot-b685827ce702*/
}
