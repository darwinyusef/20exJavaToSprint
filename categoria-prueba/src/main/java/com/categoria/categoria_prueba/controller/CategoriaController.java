package com.categoria.categoria_prueba.controller;

import com.categoria.categoria_prueba.model.CategoriaEntity;
import com.categoria.categoria_prueba.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    //Atributo
    private CategoriaService categoriaService;

    //Constructor
    @Autowired
    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    //Metodo

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody CategoriaEntity body,
                                           @RequestHeader(value = "X-Auth-Token", required = false) String token) {

        // 🔒 Validar el header personalizado
        if (token == null || !token.equals("mi-token-seguro")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
        }

        String respuesta = categoriaService.saveCategoria(body);

        // ✅ Agregar headers personalizados en la respuesta
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-App-Response", "Operación exitosa");

        return new ResponseEntity<>(respuesta, headers, HttpStatus.OK);
    }
}
