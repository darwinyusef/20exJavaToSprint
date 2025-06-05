package com.categoria.categoria_prueba.service;

import com.categoria.categoria_prueba.model.CategoriaEntity;
import com.categoria.categoria_prueba.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    //Atributo

    private CategoriaRepository categoriaRepository;

    //Constructor
    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    //Metodos

    public String saveCategoria (CategoriaEntity body){

        CategoriaEntity nuevaCategoria = new CategoriaEntity();
        nuevaCategoria.setNameCategoria(body.nameCategoria);

        categoriaRepository.save(nuevaCategoria);

        return "Se creo satisfactoriamente la nueva categoria: " + body.nameCategoria;
    }
}
