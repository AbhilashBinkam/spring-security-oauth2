package com.synchrony.assignment.imagedirectory.controller;/*
 *
 * Created by
 * Binkam Abhilash
 * on 14-November-2023
 * spring-security-oauth2
 *
 */

import com.synchrony.assignment.imagedirectory.service.client.ImgurServiceRepository;
import com.synchrony.assignment.imagedirectory.system.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/image")
public class ImageController {

    private final ImgurServiceRepository imgurServiceRepository;


    @PostMapping("/upload")
    public Result uploadImage(@RequestParam("image") MultipartFile image) {
        return imgurServiceRepository.uploadImage(image);
    }

    @GetMapping()
    public Result fetchAllRelatedImages() {
        return imgurServiceRepository.fetchRelatedImages();
    }

}
