package com.image.spring.security.imagedirectory.system;/*
 *
 * Created by
 * Binkam Abhilash
 * on 14-November-2023
 * spring-security-oauth2
 *
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AccessTokenResponse {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private long expiresIn;

    @JsonProperty("token_type")
    private String tokenType;

    private String scope;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("account_id")
    private long accountId;

    @JsonProperty("account_username")
    private String accountUsername;
}
