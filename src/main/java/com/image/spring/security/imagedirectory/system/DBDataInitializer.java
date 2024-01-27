package com.image.spring.security.imagedirectory.system;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * image-directory
 *
 */

import com.image.spring.security.imagedirectory.entity.ApplicationUser;
import com.image.spring.security.imagedirectory.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DBDataInitializer implements CommandLineRunner {

    private final UserService userService;


    public DBDataInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {


        // Create some users.
        ApplicationUser u1 = new ApplicationUser();
        u1.setId(1);
        u1.setUsername("adminuser");
        u1.setPassword("admin123");
        u1.setEnabled(true);
        u1.setRoles("admin user");

        ApplicationUser u2 = new ApplicationUser();
        u2.setId(2);
        u2.setUsername("firstUser");
        u2.setPassword("firstUser123");
        u2.setEnabled(true);
        u2.setRoles("user");

        ApplicationUser u3 = new ApplicationUser();
        u3.setId(3);
        u3.setUsername("secondUser");
        u3.setPassword("secondUser123");
        u3.setEnabled(false);
        u3.setRoles("user");

        this.userService.save(u1);
        this.userService.save(u2);
        this.userService.save(u3);
    }

}
