package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    private static final String UPLOADED_FOLDER = "uploads/";
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping("/upload")
    public ResponseEntity<String> getUploadPage() {
        return ResponseEntity.ok("File is being uploaded");
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        logger.info("Received a file upload request");
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }

        try {
            // Sprawdzenie i utworzenie katalogu jeśli nie istnieje
            Path folderPath = Paths.get(UPLOADED_FOLDER);
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
            }

            // Zapisz plik na serwerze
            byte[] bytes = file.getBytes();
            Path path = folderPath.resolve(file.getOriginalFilename());
            Files.write(path, bytes);

            // Pobranie rozmiaru pliku
            long fileSize = Files.size(path);

            String message = String.format("File uploaded successfully: %s (Size: %d bytes)", file.getOriginalFilename(), fileSize);
            logger.info(message);
            return ResponseEntity.ok(message);
        } catch (IOException e) {
            logger.error("Failed to upload file: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
        }
    }
}
