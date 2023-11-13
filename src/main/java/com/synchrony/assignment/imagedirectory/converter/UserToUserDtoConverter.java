package com.synchrony.assignment.imagedirectory.converter;

import com.synchrony.assignment.imagedirectory.dto.UserDto;
import com.synchrony.assignment.imagedirectory.entity.ApplicationUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<ApplicationUser, UserDto> {

    @Override
    public UserDto convert(ApplicationUser source) {
        // We are not setting password in DTO.
        final UserDto userDto = new UserDto(source.getId(),
                                            source.getUsername(),
                                            source.isEnabled(),
                                            source.getRoles());
        return userDto;
    }

}
