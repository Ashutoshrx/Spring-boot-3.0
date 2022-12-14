package com.test.application.service;

import dto.UserDTO;

import java.util.List;

public interface UserService {

    void addUser(UserDTO userDTO);

    List<UserDTO> fetchAllUsers();

    List<UserDTO> fetchUserByUserName(String userName);
}
