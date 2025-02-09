package com.web.demo.controls;

import com.web.demo.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(imageService.uploadImage(file));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading image");
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable String name) {
        byte[] imageData = imageService.getImage(name);
        if (imageData != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageData);
        }
        return ResponseEntity.notFound().build();
    }
}

