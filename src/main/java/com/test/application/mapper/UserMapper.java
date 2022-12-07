package com.test.application.mapper;


import com.test.application.entity.User;
import dto.UserDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring",imports = UUID.class)
public interface UserMapper {
    @Mapping(source = "user.firstName",target = "firstName")
    @Mapping(source = "user.lastName",target = "lastName")
    UserDTO userDTOToUser(User user);

    @InheritInverseConfiguration
    User userDTOToUser(UserDTO userDTO);


}
