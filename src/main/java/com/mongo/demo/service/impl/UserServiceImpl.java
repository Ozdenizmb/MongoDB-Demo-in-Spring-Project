package com.mongo.demo.service.impl;

import com.mongo.demo.dto.UserCreateDto;
import com.mongo.demo.dto.UserDto;
import com.mongo.demo.dto.UserStatus;
import com.mongo.demo.dto.UserUpdateDto;
import com.mongo.demo.mapper.UserMapper;
import com.mongo.demo.model.User;
import com.mongo.demo.reporsitory.UserRepository;
import com.mongo.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public String createUser(UserCreateDto userCreateDto) {
        User newUser = new User();
        BeanUtils.copyProperties(userCreateDto, newUser);
        newUser.setStatus(UserStatus.ACTIVE.toString());

        User responseUser = userRepository.save(newUser);

        return responseUser.getId();
    }

    @Override
    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

    @Override
    public UserDto updateUser(UserUpdateDto userUpdateDto) {
        return null;
    }

    @Override
    public Boolean deleteUser(String id) {
        return null;
    }
}
