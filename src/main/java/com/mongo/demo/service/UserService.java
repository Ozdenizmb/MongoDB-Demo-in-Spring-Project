package com.mongo.demo.service;

import com.mongo.demo.dto.UserCreateDto;
import com.mongo.demo.dto.UserDto;
import com.mongo.demo.dto.UserUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    public String createUser(UserCreateDto userCreateDto);

    public Page<UserDto> getAllUsers(Pageable pageable);

    public UserDto updateUser(String username, UserUpdateDto userUpdateDto);

    public Boolean deleteUser(String username);

}
