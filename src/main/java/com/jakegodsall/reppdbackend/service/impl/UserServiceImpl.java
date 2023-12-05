package com.jakegodsall.reppdbackend.service.impl;

import com.jakegodsall.reppdbackend.entity.User;
import com.jakegodsall.reppdbackend.exceptions.ResourceNotFoundException;
import com.jakegodsall.reppdbackend.mappers.UserMapper;
import com.jakegodsall.reppdbackend.payload.UserDto;
import com.jakegodsall.reppdbackend.repository.UserRepository;
import com.jakegodsall.reppdbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userToUserDto)
                .toList();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert from DTO to Entity
        User user = userMapper.userDtoToUser(userDto);

        // Save the entity to db
        User savedUser = userRepository.save(user);

        // Convert saved entity to DTO and return
        return userMapper.userToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        // Find the entity in the db
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        // Map entity to DTO and return
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUserById(UserDto userDto, Long id) {
        // Find the entity in the db
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        // Update the entity with fields from DTO
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        // Save updated entity
        User updatedUser = userRepository.save(user);

        // Convert updated entity to DTO and return
        return userMapper.userToUserDto(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        // Find entity in the db
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        // Delete the entity
        userRepository.delete(user);
    }
}
