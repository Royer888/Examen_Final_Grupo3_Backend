package com.example.ExamenFinal_Grupo3.repository;

import com.example.ExamenFinal_Grupo3.entity.MensajeContacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeContactoRepository extends JpaRepository<MensajeContacto, Long> {
}