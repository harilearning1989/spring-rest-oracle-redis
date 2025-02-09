package com.web.demo.services;

import com.web.demo.mongo.entity.Image;
import com.web.demo.repos.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setData(file.getBytes());
        imageRepository.save(image);
        return "Image uploaded successfully: " + file.getOriginalFilename();
    }


    @Cacheable(value = "imageAll")
    public byte[] getImageTmp(String name) {
        // Fetch from MongoDB if not in cache
        Optional<Image> imageOpt = imageRepository.findByName(name);
        if (imageOpt.isPresent()) {
            byte[] imageData = imageOpt.get().getData();
            // Cache the image in Redis for future use
            return imageData;
        }
        return null;
    }

    @Override
    @Cacheable(value = "imageAll", key = "#name")
    public byte[] getImage(String name) {
        Optional<Image> imageOpt = imageRepository.findByName(name);
        return imageOpt.map(Image::getData).orElse(null);
    }
}
