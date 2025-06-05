package com.categoria.categoria_prueba.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class CategoriaEntity {

    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    public Long idCategoria;

    @Column(name = "name_categoria")
    public String nameCategoria;

    // Constructor

    public CategoriaEntity(String nameCategoria, Long idCategoria) {
        this.nameCategoria = nameCategoria;
        this.idCategoria = idCategoria;
    }

    public CategoriaEntity(){
    }

    // Getter and Setter / Metodos


    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNameCategoria() {
        return nameCategoria;
    }

    public void setNameCategoria(String nameCategoria) {
        this.nameCategoria = nameCategoria;
    }
}
