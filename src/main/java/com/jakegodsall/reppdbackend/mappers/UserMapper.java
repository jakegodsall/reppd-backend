package com.jakegodsall.reppdbackend.mappers;

import com.jakegodsall.reppdbackend.entity.User;
import com.jakegodsall.reppdbackend.payload.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

}
