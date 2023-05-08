package com.test.application.service;

import dto.PaginationSortRequestDTO;
import dto.UserDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    void addUser(UserDTO userDTO);

    List<UserDTO> fetchAllUsers();

    List<UserDTO> fetchUserByUserName(String userName);

     List<UserDTO> fetchUsersWithSorting(PaginationSortRequestDTO paginationSortRequestDTO);
     Page<UserDTO> fetchUsersWithPaginationAndSorting(PaginationSortRequestDTO paginationSortRequestDTO);
}
