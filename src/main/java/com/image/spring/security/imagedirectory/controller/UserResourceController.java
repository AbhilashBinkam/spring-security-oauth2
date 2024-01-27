package com.image.spring.security.imagedirectory.controller;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * image-directory
 *
 */

import com.image.spring.security.imagedirectory.dto.UserDto;
import com.image.spring.security.imagedirectory.converter.UserDtoToUserConverter;
import com.image.spring.security.imagedirectory.converter.UserToUserDtoConverter;
import com.image.spring.security.imagedirectory.entity.ApplicationUser;
import com.image.spring.security.imagedirectory.service.UserService;
import com.image.spring.security.imagedirectory.service.client.ImgurServiceRepository;
import com.image.spring.security.imagedirectory.system.Result;
import com.image.spring.security.imagedirectory.system.StatusCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/users")
public class UserResourceController {


    private final UserService userService;
    private final UserDtoToUserConverter userDtoToUserConverter;
    private final UserToUserDtoConverter userToUserDtoConverter;
    private final ImgurServiceRepository imgurServiceRepository;


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

    @PostMapping
    public Result createUser(@Valid @RequestBody ApplicationUser userDetails) {

        ApplicationUser savedUser = userService.save(userDetails);
        UserDto userDto = userToUserDtoConverter.convert(savedUser);

        return new Result(true, StatusCode.SUCCESS, "User Added Successfully", userDto);
    }
}
