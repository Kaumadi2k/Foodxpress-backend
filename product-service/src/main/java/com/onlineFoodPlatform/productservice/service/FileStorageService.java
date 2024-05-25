package com.onlineFoodPlatform.productservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {
    @Value("${file.upload-dir-product")
    private String uploadDirProduct;

    @Value("${file.upload-dir-category}")
    private String uploadDirCategory;


    public String storeFile(MultipartFile file, String type) {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

        String uploadDir = type.equals("category") ? uploadDirCategory : uploadDirProduct;

        try {
            Path copyLocation = Paths.get(uploadDir).resolve(fileName).normalize();
            // Ensure the directories exist
            Files.createDirectories(copyLocation.getParent());
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + fileName, e);
        }
    }

    public Path loadFile(String fileName, String type){
        String uploadDir = type.equals("category") ? uploadDirCategory : uploadDirProduct;
        return Paths.get(uploadDir).resolve(fileName);
    }
}
