package com.image.spring.security.imagedirectory.converter;


import com.image.spring.security.imagedirectory.dto.UserDto;
import com.image.spring.security.imagedirectory.entity.ApplicationUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, ApplicationUser> {

    @Override
    public ApplicationUser convert(UserDto source) {
        ApplicationUser hogwartsUser = new ApplicationUser();
        hogwartsUser.setUsername(source.userName());
        hogwartsUser.setEnabled(source.enabled());
        hogwartsUser.setRoles(source.roles());
        return hogwartsUser;
    }

}
