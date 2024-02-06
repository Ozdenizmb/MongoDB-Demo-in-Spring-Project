package com.mongo.demo.controller;

import com.mongo.demo.api.UserApi;
import com.mongo.demo.dto.UserCreateDto;
import com.mongo.demo.dto.UserDto;
import com.mongo.demo.dto.UserUpdateDto;
import com.mongo.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<String> createUser(UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userService.createUser(userCreateDto));
    }

    @Override
    public ResponseEntity<Page<UserDto>> getAllUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.getAllUsers(pageable));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(String username, UserUpdateDto userUpdateDto) {
        return ResponseEntity.ok(userService.updateUser(username, userUpdateDto));
    }

    @Override
    public ResponseEntity<Boolean> deleteUser(String username) {
        return ResponseEntity.ok(userService.deleteUser(username));
    }
}
