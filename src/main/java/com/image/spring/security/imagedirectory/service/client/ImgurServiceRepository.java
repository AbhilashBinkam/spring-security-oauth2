package com.image.spring.security.imagedirectory.service.client;/*
 *
 * Created by
 * Binkam Abhilash
 * on 14-November-2023
 * spring-security-oauth2
 *
 */

import com.image.spring.security.imagedirectory.system.AccessTokenResponse;
import com.image.spring.security.imagedirectory.system.Result;
import com.image.spring.security.imagedirectory.system.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Slf4j
@Service
public class ImgurServiceRepository {

    public static final String ACCESS_TOKEN = "accessToken";

    private ImgurServiceProxy imgurServiceProxy;
    private ImgUrRefreshTokenGenerator imgUrRefreshTokenGenerator;

    public ImgurServiceRepository(ImgurServiceProxy imgurServiceProxy, ImgUrRefreshTokenGenerator imgUrRefreshTokenGenerator) {
        this.imgurServiceProxy = imgurServiceProxy;
        this.imgUrRefreshTokenGenerator = imgUrRefreshTokenGenerator;
    }

    Map<String, String> accessTokenCache = new HashMap<>();

    Supplier<AccessTokenResponse> accessTokenSupplier = () -> {
        AccessTokenResponse accessTokenResponse = imgUrRefreshTokenGenerator.refreshAccessToken();
        accessTokenCache.put(ACCESS_TOKEN, accessTokenResponse.getAccessToken());
        log.info("Access Token Response :: {}", accessTokenResponse);
        return accessTokenResponse;
    };

    public Result fetchRelatedImages() {

        Map<String, String> httpHeaders = constructHttpHeaders(accessTokenSupplier.get());
        Object allImages = imgurServiceProxy.getAllRelatedImages(httpHeaders);

        Result result = Result.builder()
                .code(StatusCode.SUCCESS)
                .flag(true)
                .message("Fetched all the images related to the user account")
                .data(allImages)
                .build();

        log.info("Fetched all the images from the imgur service :: {} ", result);

        return result;
    }

    private static Map<String, String> constructHttpHeaders(AccessTokenResponse accessTokenResponse) {
        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put("Authorization", "Bearer " + accessTokenResponse.getAccessToken());
        return httpHeaders;
    }

    public Result uploadImage(MultipartFile imageData) {

        Map<String, String> httpHeaders = constructHttpHeaders(accessTokenSupplier.get());
        Object imageUploadResponse = imgurServiceProxy.uploadImage(httpHeaders, imageData);

        Result result = Result.builder()
                .code(StatusCode.SUCCESS)
                .flag(true)
                .message("Image Upload completed Successfully")
                .data(imageUploadResponse)
                .build();

        log.info("Uploaded Image Data :: {} ", result);
        return result;
    }

}
