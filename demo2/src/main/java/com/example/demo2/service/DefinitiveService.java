package com.example.demo2.service;

import org.springframework.stereotype.Service;

@Service
public class DefinitiveService {
    private String keyOculta = "esto-esta-oculto";

    public String generarSaludo(String name) {
        String nombreEncriptado = encriptar(name);
        return "Hola " + nombreEncriptado + ", bienvenido al sistema.";
    }

    private String encriptar(String texto) {
        return "Encriptado-" + texto;
    }

    public String obtenerClaveSecreta() {
        return keyOculta;
    }
}
