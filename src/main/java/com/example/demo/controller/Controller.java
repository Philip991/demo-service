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
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@RestController
@RequestMapping("/api")

public class Controller {

    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody List<Integer> numbers) {
        int result = numbers.stream().mapToInt(Integer::intValue).sum();
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(String.valueOf(result));
    }
}
