package com.image.spring.security.imagedirectory.service.client;/*
 *
 * Created by
 * Binkam Abhilash
 * on 14-November-2023
 * spring-security-oauth2
 *
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.image.spring.security.imagedirectory.system.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@Component
public class ImgUrRefreshTokenGenerator {

    @Value("${imgur.auth.server.url:https://api.imgur.com/oauth2/token}")
    private String tokenEndpointUrl;

    @Value("${imgur.credentials.clientId}")
    private String clientId;

    @Value("${imgur.credentials.clientSecret}")
    private String clientSecret;

    @Value("${imgur.credentials.refresh-access-token}")
    private String refreshAccessToken;

    private final RestTemplate restTemplate;

    public AccessTokenResponse refreshAccessToken() {

        // Set the Request Headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        httpHeaders.setBasicAuth(clientId, clientSecrets);

        // Set the request parameters
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.set("grant_type", "refresh_token");
        requestBody.set("refresh_token", refreshAccessToken);
        requestBody.set("client_id", clientId);
        requestBody.set("client_secret", clientSecret);

        // Build the request URL
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromHttpUrl(tokenEndpointUrl);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(componentsBuilder.toUriString(), HttpMethod.POST, requestEntity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(responseEntity.getBody(), AccessTokenResponse.class);
        } catch (JsonProcessingException e) {
            log.error("Json Processing Exception :: {} ", e);
            throw new RuntimeException(e);
        }
    }
}
