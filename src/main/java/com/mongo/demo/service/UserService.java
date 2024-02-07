package com.mongo.demo.service;

import com.mongo.demo.dto.UserCreateDto;
import com.mongo.demo.dto.UserDto;
import com.mongo.demo.dto.UserUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    String createUser(UserCreateDto userCreateDto);

    Page<UserDto> getAllUsers(Pageable pageable);

    UserDto updateUser(String username, UserUpdateDto userUpdateDto);

    Boolean deleteUser(String username);

    Long getRegisteredUserCount();

}
