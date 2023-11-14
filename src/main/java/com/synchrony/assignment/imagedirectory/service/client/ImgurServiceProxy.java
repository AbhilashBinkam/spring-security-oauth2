package com.synchrony.assignment.imagedirectory.service.client;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * spring-security-oauth2
 *
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@FeignClient(url = "https://api.imgur.com/", value = "imgurClient")
public interface ImgurServiceProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/3/account/abhilashtesting123/images/0")
    Object getAllRelatedImages(@RequestHeader Map<String, String> headers);

    @RequestMapping(method = RequestMethod.POST, value = "/3/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object uploadImage(@RequestHeader Map<String, String> headers, @RequestPart("image")MultipartFile image);


}
