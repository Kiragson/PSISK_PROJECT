package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/converter")
public class ConverterController {

    private static final Logger logger = LoggerFactory.getLogger(ConverterController.class);

    @GetMapping
    public ResponseEntity<?> handleEmptyPath() {
        logger.warn("No data provided in the request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Brak wprowadzonych danych");
    }

    @GetMapping("/radiansToDegrees/{radians}")
    public ResponseEntity<?> radiansToDegrees(@PathVariable String radians) {
        try {
            logger.info("Converting radians to degrees: {}", radians);
            double rad = Double.parseDouble(radians);
            return ResponseEntity.ok(Math.toDegrees(rad));
        } catch (NumberFormatException e) {
            logger.error("Error converting radians to degrees: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wartość musi być liczbą");
        }
    }

    @GetMapping("/degreesToRadians/{degrees}")
    public ResponseEntity<?> degreesToRadians(@PathVariable String degrees) {
        try {
            logger.info("Converting degrees to radians: {}", degrees);
            double deg = Double.parseDouble(degrees);
            return ResponseEntity.ok(Math.toRadians(deg));
        } catch (NumberFormatException e) {
            logger.error("Error converting degrees to radians: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wartość musi być liczbą");
        }
    }

    @GetMapping("/celsiusToFahrenheit/{celsius}")
    public ResponseEntity<?> celsiusToFahrenheit(@PathVariable String celsius) {
        try {
            logger.info("Converting celsius to fahrenheit: {}", celsius);
            double cel = Double.parseDouble(celsius);
            return ResponseEntity.ok((cel * 9 / 5) + 32);
        } catch (NumberFormatException e) {
            logger.error("Error converting celsius to fahrenheit: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wartość musi być liczbą");
        }
    }

    @GetMapping("/fahrenheitToCelsius/{fahrenheit}")
    public ResponseEntity<?> fahrenheitToCelsius(@PathVariable String fahrenheit) {
        try {
            logger.info("Converting fahrenheit to celsius: {}", fahrenheit);
            double fah = Double.parseDouble(fahrenheit);
            return ResponseEntity.ok((fah - 32) * 5 / 9);
        } catch (NumberFormatException e) {
            logger.error("Error converting fahrenheit to celsius: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wartość musi być liczbą");
        }
    }
}
