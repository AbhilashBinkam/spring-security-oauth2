package com.synchrony.assignment.imagedirectory.controller;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * image-directory
 *
 */

import com.synchrony.assignment.imagedirectory.converter.UserDtoToUserConverter;
import com.synchrony.assignment.imagedirectory.converter.UserToUserDtoConverter;
import com.synchrony.assignment.imagedirectory.dto.UserDto;
import com.synchrony.assignment.imagedirectory.entity.ApplicationUser;
import com.synchrony.assignment.imagedirectory.service.UserService;
import com.synchrony.assignment.imagedirectory.system.Result;
import com.synchrony.assignment.imagedirectory.system.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/users")
public class UserController {


    private final UserService userService;
    private final UserDtoToUserConverter userDtoToUserConverter;
    private final UserToUserDtoConverter userToUserDtoConverter;


    @GetMapping
    public Result findAllUsers() {
        List<ApplicationUser> foundHogwartsUsers = this.userService.findAll();

        // Convert foundUsers to a list of UserDtos.
        List<UserDto> userDtos = foundHogwartsUsers.stream()
                .map(this.userToUserDtoConverter::convert)
                .collect(Collectors.toList());

        // Note that UserDto does not contain password field.
        return new Result(true, StatusCode.SUCCESS, "Find All Success", userDtos);
    }
}
