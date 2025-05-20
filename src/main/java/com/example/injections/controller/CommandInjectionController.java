package com.example.injections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cmd")
public class CommandInjectionController {

    @GetMapping("/ping")
    public String pingHost(@RequestParam String host) {
        try {
            String command = "ping -c 1 " + host;
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            return "Fout bij uitvoeren van commando: " + e.getMessage();
        }
    }
}
