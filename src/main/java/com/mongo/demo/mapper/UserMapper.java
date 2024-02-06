package com.mongo.demo.mapper;

import com.mongo.demo.dto.UserDto;
import com.mongo.demo.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {



}
