package com.sdnath.JournalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Healthchek {
    @GetMapping("/greet")
    public String greet(){
        return "hiii welcome";
    }
}
