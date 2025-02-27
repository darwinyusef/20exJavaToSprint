package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomerController {

    @GetMapping("/into")
    public Map<String, String> prueba(@RequestParam String name) {
        Map<String, String> response = new HashMap<>();
        response.put("name", "Hola " + name);
        response.put("menssage", "Bienvenido a sprint get");
        return response;
    }

    @PostMapping("/prueba")
    public Map<String, String> rawBody(@RequestBody Map<String, String> body) {
        return body;
    }

    // 📌 Parámetro de ruta (path param): /api/saludo/Juan
    @GetMapping("/saludo/{nombre}")
    public Map<String, String> saludoPath(@PathVariable String nombre) {
        return Map.of("mensaje", "Hola " + nombre);
    }
}
