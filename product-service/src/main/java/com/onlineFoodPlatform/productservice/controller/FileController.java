package com.onlineFoodPlatform.productservice.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private final String uploadDirCategory = "uploads/category/";
    private final String uploadDirProduct = "uploads/products/";

    @GetMapping("/{type}/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String type, @PathVariable String filename) {
        try {
            Path filePath = loadFile(filename, type);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Path loadFile(String fileName, String type) {
        String uploadDir = type.equals("category") ? uploadDirCategory : uploadDirProduct;
        return Paths.get(uploadDir).resolve(fileName).normalize();
    }
}

