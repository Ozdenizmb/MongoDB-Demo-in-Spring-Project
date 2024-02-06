package com.mongo.demo.dto;

public record UserDto(
        String id,
        String username,
        String firstName,
        String lastName,
        String status
) {
}
