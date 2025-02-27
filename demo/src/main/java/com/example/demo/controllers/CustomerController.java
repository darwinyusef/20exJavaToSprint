package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
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

    @GetMapping("/headerinfo")
    public ResponseEntity<String> secureData(
            @RequestHeader("mandatory_info") String mandatoryInfo) {
        return ResponseEntity.ok("Acceso permitido con header: " + mandatoryInfo);
    }

    @GetMapping("/base64Prueba")
    public String base64Prueba() {
        String textoOriginal = "codigoautorizado";
        String base64Encoded = Base64.getEncoder().encodeToString(textoOriginal.getBytes());
        return "Base64 Codificado: " + base64Encoded;
    }


    @GetMapping("/authorization")
    public ResponseEntity<String> headerSecureAuthorization(
            @RequestHeader(value = "Authorization", required = false) String authHeader,
            @RequestHeader(value = "Other", required = false) String otherHeader) {

        if (authHeader == null || otherHeader == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Faltan headers obligatorios.");
        }

        return ResponseEntity.ok("Acceso permitido con header: " + authHeader + " - " + otherHeader);
    }

    @GetMapping("/authorization2")
    public ResponseEntity<String> headerSecure(
            @RequestHeader(value = "Authorization", required = false) String authHeader,
            @RequestHeader(value = "CapaFrontend", required = false) String otherHeader) {

        try {
            if (authHeader == null || otherHeader == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Faltan headers obligatorios para la consulta.");
            }

            byte[] decodedBytes;
            try {
                decodedBytes = Base64.getDecoder().decode(authHeader);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El header Authorization no está en formato Base64 válido.");
            }

            String textoDecodificado = new String(decodedBytes);
            if ("codigoautorizado".equals(textoDecodificado)) {
                return ResponseEntity.ok("Acceso permitido con header: " + textoDecodificado);
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Código de autorización incorrecto.");

        } catch (Exception e) {
            e.printStackTrace(); // Log para depuración
            return ResponseEntity.status(HttpStatus.BAD_REQUEST )
                    .body("Se ha generado un error. Consulte al administrador del sistema. " + e.getMessage());
        }
    }
}
