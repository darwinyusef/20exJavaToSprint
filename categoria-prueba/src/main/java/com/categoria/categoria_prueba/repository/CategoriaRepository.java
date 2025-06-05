package com.categoria.categoria_prueba.repository;


import com.categoria.categoria_prueba.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
