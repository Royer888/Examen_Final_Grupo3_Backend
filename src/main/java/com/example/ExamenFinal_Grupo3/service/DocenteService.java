package com.example.ExamenFinal_Grupo3.service;

import com.example.ExamenFinal_Grupo3.entity.Docente;
import com.example.ExamenFinal_Grupo3.repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public List<Docente> listarDocentes() {
        return docenteRepository.findAll();
    }

    public Optional<Docente> buscarPorId(Long id) {
        return docenteRepository.findById(id);
    }

    public Docente guardarDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    public Optional<Docente> actualizarDocente(Long id, Docente docenteActualizado) {
        return docenteRepository.findById(id).map(docenteExistente -> {
            docenteExistente.setNombre(docenteActualizado.getNombre());
            docenteExistente.setApellido(docenteActualizado.getApellido());
            docenteExistente.setMateria(docenteActualizado.getMateria());
            docenteExistente.setCargo(docenteActualizado.getCargo());
            docenteExistente.setCorreo(docenteActualizado.getCorreo());
            docenteExistente.setTelefono(docenteActualizado.getTelefono());
            docenteExistente.setImagenUrl(docenteActualizado.getImagenUrl());

            return docenteRepository.save(docenteExistente);
        });
    }

    public boolean eliminarDocente(Long id) {
        if (docenteRepository.existsById(id)) {
            docenteRepository.deleteById(id);
            return true;
        }

        return false;
    }
}