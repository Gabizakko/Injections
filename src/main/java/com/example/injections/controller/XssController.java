package com.example.injections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XssController {

    @GetMapping("/xss-test")
    public String xssTest(@RequestParam String input) {
        return "<html><body>Result: " + input + "</body></html>";
    }


}
