package com.example.ExamenFinal_Grupo3.repository;

import com.example.ExamenFinal_Grupo3.entity.Galeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GaleriaRepository extends JpaRepository<Galeria, Long> {

    List<Galeria> findByCategoria(String categoria);
}