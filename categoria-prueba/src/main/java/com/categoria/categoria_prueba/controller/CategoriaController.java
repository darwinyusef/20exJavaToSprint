package com.categoria.categoria_prueba.controller;

import com.categoria.categoria_prueba.model.CategoriaEntity;
import com.categoria.categoria_prueba.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String saveUser(@RequestBody CategoriaEntity body) {

        String respuesta = categoriaService.saveCategoria(body);

        return respuesta;
    }
}
