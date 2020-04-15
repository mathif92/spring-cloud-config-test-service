package com.mathif92.testservice.controller;

import com.mathif92.testservice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${test.value:Test}")
    private String testValue;

    @Autowired
    private TestService testService;

    @GetMapping("")
    public ResponseEntity getTestValue() {
        return ResponseEntity.ok(this.testValue);
    }

    @GetMapping("/transactional")
    public ResponseEntity testTransactionalMethod() {
        testService.testTransactionalMethod();

        return ResponseEntity.ok("Yeeah");
    }

}
