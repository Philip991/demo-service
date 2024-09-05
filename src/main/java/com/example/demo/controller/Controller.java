package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestBody List<Integer> numbers) {
        int result = numbers.stream().mapToInt(Integer::intValue).sum(); // Example calculation
        return ResponseEntity.ok(String.valueOf(result));
    }
}
