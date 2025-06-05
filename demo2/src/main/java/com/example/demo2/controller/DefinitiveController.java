package com.example.demo2.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo2.service.DefinitiveService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DefinitiveController {

    private final DefinitiveService definitiveService;

    @Autowired
    public DefinitiveController(DefinitiveService definitiveService) {
        this.definitiveService = definitiveService;
    }

    @GetMapping("/")
    public String home() {
        return "Hola mundo";
    }

    // /api/into?name=1
    @GetMapping("/into")
    public Map<String, String> prueba(@RequestParam String name) {
        Map<String, String> response = new HashMap<>();
        response.put("name", "Hola " + name);
        response.put("message", "Spring");
        return response;
    }

    @GetMapping("/names/{name}")
    public String name(@PathVariable String name) {
        return definitiveService.generarSaludo(name);
    }

     @GetMapping("/claveSecreta")
    public String obtenerClaveSecreta() {
        return definitiveService.obtenerClaveSecreta();
    }
}
