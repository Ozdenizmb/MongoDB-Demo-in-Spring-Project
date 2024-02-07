package com.mongo.demo.service.impl;

import com.mongo.demo.dto.UserCreateDto;
import com.mongo.demo.dto.UserDto;
import com.mongo.demo.dto.UserStatus;
import com.mongo.demo.dto.UserUpdateDto;
import com.mongo.demo.exception.ErrorMessages;
import com.mongo.demo.exception.UserException;
import com.mongo.demo.mapper.UserMapper;
import com.mongo.demo.model.User;
import com.mongo.demo.reporsitory.UserRepository;
import com.mongo.demo.service.AggregationService;
import com.mongo.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AggregationService aggregationService;

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
    public UserDto updateUser(String username, UserUpdateDto userUpdateDto) {
        User existUser = userRepository.findByUsername(username);

        if(existUser == null) {
            throw UserException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.USER_NOT_FOUND);
        }

        BeanUtils.copyProperties(userUpdateDto, existUser);
        User responseUser = userRepository.save(existUser);

        return userMapper.toDto(responseUser);
    }

    @Override
    public Boolean deleteUser(String username) {
        User existUser = userRepository.findByUsername(username);

        if(existUser == null) {
            throw UserException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.USER_NOT_FOUND);
        }
        else {
            userRepository.deleteByUsername(username);
            return true;
        }
    }

    @Override
    public Long getRegisteredUserCount() {
        return aggregationService.getRegisteredUserCount();
    }

}
