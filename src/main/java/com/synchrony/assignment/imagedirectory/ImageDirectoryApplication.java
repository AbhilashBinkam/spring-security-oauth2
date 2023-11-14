package com.synchrony.assignment.imagedirectory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ImageDirectoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageDirectoryApplication.class, args);
	}

}
