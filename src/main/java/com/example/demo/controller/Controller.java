package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @PostMapping("/calculate")
    public int calculateSum(@RequestBody List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
