package com.example.demo.controller;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

@RestController
@RequestMapping("/api")

public class Controller {

    @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> calculateSum(HttpServletRequest request) {
        try (InputStream inputStream = request.getInputStream()) {
            // Read the octet-stream as a string
            String input = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines().collect(Collectors.joining("\n"));

            // Assume the input is a comma-separated list of integers, like "1,2,3,4"
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // Perform the calculation
            int result = numbers.stream().mapToInt(Integer::intValue).sum();

            // Return the result as plain text
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(String.valueOf(result));
        } catch (IOException | NumberFormatException e) {
            // Handle any errors such as invalid input or I/O issues
            return ResponseEntity.badRequest().body("Invalid input or data format.");
        }
    }

}
