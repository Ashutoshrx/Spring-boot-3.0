package com.test.application.controller;


import com.test.application.service.UserService;
import dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
public class UserControllerTest {
    @MockBean
    private UserService userService;
    @Autowired
    private UserController userController;

    @Test
    public void testAddUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("ashu@gmail.com");
        userDTO.setFirstName("ashu");
        userDTO.setLastName("tosh");
        Mockito.spy(userService).addUser(userDTO);
        userController.addUser(userDTO);
    }


}