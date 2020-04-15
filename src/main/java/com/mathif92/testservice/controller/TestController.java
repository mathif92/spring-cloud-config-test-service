package com.mathif92.testservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${test.value:Test}")
    private String testValue;

    @GetMapping("")
    public ResponseEntity getTestValue() {
        return ResponseEntity.ok(this.testValue);
    }

}
