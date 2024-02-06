package com.mongo.demo.dto;

public record UserUpdateDto(
        String firstName,
        String lastName,
        String password
) {
}
