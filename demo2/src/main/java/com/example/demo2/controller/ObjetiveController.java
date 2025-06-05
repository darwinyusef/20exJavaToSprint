package com.example.demo2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ObjetiveController {

    public String modelo(Integer a) {
        return String.valueOf(10 + a);
    }

    @GetMapping("/positive")
    public String contenido(@RequestParam Integer a) {
        return this.modelo(a);
    }

    // 📌 Parámetro de ruta (path param): /api/saludo/Juan
    @GetMapping("/saludo/{nombre}")
    public Map<String, String> saludoPath(@PathVariable String nombre) {
        return Map.of("mensaje", "Hola " + nombre);
    }

}
