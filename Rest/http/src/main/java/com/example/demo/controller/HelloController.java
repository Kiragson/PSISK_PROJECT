package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @PostMapping("/greet")
    public ResponseEntity<String> greet(@RequestBody String message) {
        if ("Hello".equalsIgnoreCase(message.trim())) {
            return ResponseEntity.ok("World");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");
        }
    }
}
