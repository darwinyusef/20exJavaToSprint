package com.aquicreamos.example.controllers;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class GenericController {
    
    @GetMapping("/")
    public String home() {
        return "hola mundo";
    }
   
}
