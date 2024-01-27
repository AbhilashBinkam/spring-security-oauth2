package com.image.spring.security.imagedirectory.converter;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * image-directory
 *
 */

import com.image.spring.security.imagedirectory.dto.UserDto;
import com.image.spring.security.imagedirectory.entity.ApplicationUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserToUserConverter implements Converter<ApplicationUser, UserDto> {

    @Override
    public UserDto convert(ApplicationUser source) {

        final UserDto user = new UserDto(source.getId(), source.getUsername(), source.isEnabled(), source.getRoles());
        return user;
    }
}
