package com.jakegodsall.reppdbackend.controllers;

import com.jakegodsall.reppdbackend.payload.UserDto;
import com.jakegodsall.reppdbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    private static final String API_V1_LIST = "/api/v1/users";
    private static final String API_V1_LIST_ID = API_V1_LIST + "/{id}";

    private final UserService userService;

    @GetMapping(API_V1_LIST)
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping(API_V1_LIST)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto
    ) {
        UserDto createdUser = userService.createUser(userDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdUser);
    }

    @GetMapping(API_V1_LIST_ID)
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(API_V1_LIST_ID)
    public ResponseEntity<UserDto> updateUserById(
            @RequestBody UserDto userDto,
            @PathVariable Long id
    ) {
        UserDto updatedUser = userService.updateUserById(userDto, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping(API_V1_LIST_ID)
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
