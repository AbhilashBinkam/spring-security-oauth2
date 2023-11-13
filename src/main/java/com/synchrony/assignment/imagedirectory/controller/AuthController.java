package com.synchrony.assignment.imagedirectory.controller;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * image-directory
 *
 */

import com.synchrony.assignment.imagedirectory.converter.UserToUserDtoConverter;
import com.synchrony.assignment.imagedirectory.dto.UserDto;
import com.synchrony.assignment.imagedirectory.entity.ApplicationUser;
import com.synchrony.assignment.imagedirectory.jwt.AuthService;
import com.synchrony.assignment.imagedirectory.service.UserService;
import com.synchrony.assignment.imagedirectory.system.Result;
import com.synchrony.assignment.imagedirectory.system.StatusCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/users")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final UserToUserDtoConverter userToUserDtoConverter;

    @PostMapping("/login")
    public Result login(Authentication authentication) {
        return Result.builder()
                .message("User details and created new Token")
                .flag(true)
                .code(StatusCode.SUCCESS)
                .data(authService.createLoginFrom(authentication)).build();
    }

    @PostMapping
    public Result createUser(@Valid @RequestBody ApplicationUser userDetails) {

        ApplicationUser savedUser = userService.save(userDetails);
        UserDto userDto = userToUserDtoConverter.convert(savedUser);

        return new Result(true, StatusCode.SUCCESS, "User Added Successfully", userDto);
    }



}
