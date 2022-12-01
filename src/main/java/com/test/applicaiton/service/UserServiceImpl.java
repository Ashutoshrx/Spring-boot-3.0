package com.test.applicaiton.service;

import com.test.applicaiton.entity.User;
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
        User user = null;
        if (!ObjectUtils.isEmpty(userDTO)) {
            user = userMapper.userDTOToUser(userDTO);
            LOGGER.debug("UserId is:{}", user.getUserId());
        }
        if (!ObjectUtils.isEmpty(user)) {
            userRepository.save(user);
        }
        LOGGER.info("User has been added with userName as:{}", userDTO.getFirstName());
    }

    @Override
    public List<UserDTO> fetchAllUsers() {
        LOGGER.info("Fetching all users list");
        List<User> userList = userRepository.findAll();
        return userList.stream().map(user -> userMapper.userDTOToUser(user)).toList();
    }

    @Override
    public List<UserDTO> fetchUserByUserName(String userName) {

        if (ObjectUtils.isEmpty(userName)) {
//            Need to throw exception
            return null;
        } else {
            LOGGER.info("Fetching users by name:{}", userName);
            List<User> userList = userRepository.fetchUsersByUserName(userName);
            if (!CollectionUtils.isEmpty(userList)) {
                LOGGER.debug("Data is:{}", userList.get(0).getUserId());
                return userList.stream().map(user -> userMapper.userDTOToUser(user)).toList();
            }
            return null;

        }
    }
}
