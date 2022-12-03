package com.test.applicaiton.service;

import com.test.applicaiton.entity.User;
import com.test.applicaiton.exception.ApplicationServiceException;
import com.test.applicaiton.mapper.UserMapper;
import com.test.applicaiton.repository.UserRepository;
import dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(UserDTO userDTO) {
        userDTO.setUserId(UUID.randomUUID().toString());
        LOGGER.info("Started adding user with userId:{}", userDTO.getUserId());
        try {
            if (ObjectUtils.isEmpty(userDTO) || userDTO.getEmail().isEmpty() || userDTO.getFirstName().isEmpty()) {
                throw new ApplicationServiceException("601", "Invalid input");
            } else {
                User existingUser = userRepository.findByFirstName(userDTO.getFirstName());
                if (ObjectUtils.isEmpty(existingUser)) {
                    User user = userMapper.userDTOToUser(userDTO);
                    LOGGER.debug("UserId is:{}", user.getUserId());
                    if (!ObjectUtils.isEmpty(user)) {
                        userRepository.save(user);
                        LOGGER.info("User has been added with name as:{}", userDTO.getFirstName());
                    }
                } else {
                    LOGGER.debug("User Found in the database with the name :{}", userDTO.getFirstName());
                    existingUser.setFirstName(userDTO.getFirstName());
                    existingUser.setEmail(userDTO.getEmail());
                    existingUser.setLastName(userDTO.getLastName());
                    userRepository.saveAndFlush(existingUser);
                    LOGGER.info("Updated data with name :{}", userDTO.getFirstName());
                }
            }
        } catch (IllegalArgumentException e) {
            throw new ApplicationServiceException("602", "Unable to save the data" + e.getMessage());
        } catch (Exception e) {
            throw new ApplicationServiceException("603", "Something went wrong" + e.getMessage());
        }

    }

    @Override
    public List<UserDTO> fetchAllUsers() {
        LOGGER.info("Fetching all users list");
        try {
            List<User> userList = userRepository.findAll();
            if (CollectionUtils.isEmpty(userList)) {
                throw new ApplicationServiceException("NOT FOUND", "No data found");
            }
            return userList.stream().map(user -> userMapper.userDTOToUser(user)).toList();
        } catch (RuntimeException e) {
            throw new ApplicationServiceException("603", "Failed to fetch data" + e.getMessage());
        }

    }

    @Override
    public List<UserDTO> fetchUserByUserName(String userName) {

        if (ObjectUtils.isEmpty(userName)) {
            throw new ApplicationServiceException("601", "Invalid Input");
        } else {
            try {
                LOGGER.info("Fetching users by name:{}", userName);
                List<User> userList = userRepository.fetchUsersByUserName((userName));
                if (!CollectionUtils.isEmpty(userList)) {
                    LOGGER.debug("Data is:{}", userList.get(0).getUserId());
                    return userList.stream().map(user -> userMapper.userDTOToUser(user)).toList();
                } else {
                    throw new ApplicationServiceException("602", "No Data Found");
                }
            } catch (Exception e) {
                throw new RuntimeException("Something went wrong while fetching data: " + e.getMessage());
            }

        }
    }
}
