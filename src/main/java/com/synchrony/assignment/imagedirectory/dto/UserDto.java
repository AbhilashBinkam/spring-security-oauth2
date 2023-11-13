package com.synchrony.assignment.imagedirectory.dto;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * image-directory
 *
 */

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;


public record UserDto(Integer id,
                      @NotEmpty(message = "username is required")
                      String userName,
                      boolean enabled,
                      @NotEmpty(message = "roles are required")
                      String roles) {
}
