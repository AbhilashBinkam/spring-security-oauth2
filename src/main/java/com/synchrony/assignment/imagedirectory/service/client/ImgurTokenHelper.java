package com.synchrony.assignment.imagedirectory.service.client;/*
 *
 * Created by
 * Binkam Abhilash
 * on 14-November-2023
 * spring-security-oauth2
 *
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/*@Slf4j
@Component
public class ImgurTokenHelper {

    private static final String CLIENT_ID = "clientId";
    private static final String CLIENT_SECRET = "clientSecret";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ImgurClientPropertySource imgurClientPropertySource;

    public Map<String, String> imgurAccessToken() {

        Map<String, String> headers = new HashMap<>();

        HttpHeaders httpHeaders = new HttpHeaders();
        String clientDetails = imgurClientPropertySource.getCredentials().get(CLIENT_ID) + ":" 
                + imgurClientPropertySource.getCredentials().get(CLIENT_SECRET);
        String encodedClientDetails = Base64.getEncoder().encodeToString(clientDetails.getBytes());
        httpHeaders.set("Authorization", "Basic " + encodedClientDetails);
        HttpEntity<?> httpEntity = new HttpEntity<>(null, httpHeaders);
        log.info("OutBound Request :: {} ", imgurClientPropertySource.getImgurEndpoint());

        Object response = restTemplate.postForObject(imgurClientPropertySource.getImgurEndpoint(), httpEntity, Object.class);
        if(null != response) {
            headers = (Map<String, String>) response;
        }

        return headers;
    }


}*/
