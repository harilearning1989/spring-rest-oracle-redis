package com.web.demo.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String uploadImage(MultipartFile file) throws IOException;

    byte[] getImage(String name);
}
