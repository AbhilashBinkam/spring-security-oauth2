package com.image.spring.security.imagedirectory.controller;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * image-directory
 *
 */

import com.image.spring.security.imagedirectory.jwt.AuthService;
import com.image.spring.security.imagedirectory.system.Result;
import com.image.spring.security.imagedirectory.system.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/users")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public Result login(Authentication authentication) {
        return Result.builder()
                .message("User details and created new Token")
                .flag(true)
                .code(StatusCode.SUCCESS)
                .data(authService.createLoginFrom(authentication)).build();
    }
}
