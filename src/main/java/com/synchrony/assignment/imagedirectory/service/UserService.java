package com.synchrony.assignment.imagedirectory.service;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * image-directory
 *
 */

import com.synchrony.assignment.imagedirectory.entity.ApplicationUser;
import com.synchrony.assignment.imagedirectory.entity.ApplicationUserPrincipal;
import com.synchrony.assignment.imagedirectory.exception.ObjectNotFoundException;
import com.synchrony.assignment.imagedirectory.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Transactional
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public List<ApplicationUser> findAll() {
        return this.userRepository.findAll();
    }

    public ApplicationUser findById(Integer userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException("user", userId));
    }

    public ApplicationUser save(ApplicationUser applicationUser) {
        applicationUser.setPassword(this.passwordEncoder.encode(applicationUser.getPassword()));
        return userRepository.save(applicationUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("verify the user with the user name :: {} ", username);
        return userRepository.findByUsername(username).map(applicationUser -> new ApplicationUserPrincipal(applicationUser))
                .orElseThrow(() -> new UsernameNotFoundException("username " + username + " is not found."));
    }
}
