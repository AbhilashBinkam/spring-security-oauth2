package com.synchrony.assignment.imagedirectory.jwt;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * image-directory
 *
 */

import com.synchrony.assignment.imagedirectory.converter.ApplicationUserToUserConverter;
import com.synchrony.assignment.imagedirectory.dto.UserDto;
import com.synchrony.assignment.imagedirectory.entity.ApplicationUser;
import com.synchrony.assignment.imagedirectory.entity.ApplicationUserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final JwtProvider jwtProvider;
    private final ApplicationUserToUserConverter converter;

    public Map<String, Object> createLoginFrom(Authentication authentication) {

        ApplicationUserPrincipal principal = (ApplicationUserPrincipal) authentication.getPrincipal();
        ApplicationUser applicationUser = principal.getApplicationUser();
        UserDto userDto = converter.convert(applicationUser);
        String token = jwtProvider.createToken(authentication);

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("userInfo", userDto);
        resultMap.put("token", token);

        return resultMap;
    }



}
