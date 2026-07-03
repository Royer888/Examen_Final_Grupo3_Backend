package com.example.ExamenFinal_Grupo3.service;

import com.example.ExamenFinal_Grupo3.entity.Galeria;
import com.example.ExamenFinal_Grupo3.repository.GaleriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GaleriaService {

    private final GaleriaRepository galeriaRepository;

    public GaleriaService(GaleriaRepository galeriaRepository) {
        this.galeriaRepository = galeriaRepository;
    }

    public List<Galeria> listarGaleria() {
        return galeriaRepository.findAll();
    }

    public Optional<Galeria> buscarPorId(Long id) {
        return galeriaRepository.findById(id);
    }

    public List<Galeria> buscarPorCategoria(String categoria) {
        return galeriaRepository.findByCategoria(categoria);
    }

    public Galeria guardarGaleria(Galeria galeria) {
        return galeriaRepository.save(galeria);
    }

    public Optional<Galeria> actualizarGaleria(Long id, Galeria galeriaActualizada) {
        return galeriaRepository.findById(id).map(galeriaExistente -> {
            galeriaExistente.setTitulo(galeriaActualizada.getTitulo());
            galeriaExistente.setDescripcion(galeriaActualizada.getDescripcion());
            galeriaExistente.setImagenUrl(galeriaActualizada.getImagenUrl());
            galeriaExistente.setCategoria(galeriaActualizada.getCategoria());
            galeriaExistente.setFecha(galeriaActualizada.getFecha());

            return galeriaRepository.save(galeriaExistente);
        });
    }

    public boolean eliminarGaleria(Long id) {
        if (galeriaRepository.existsById(id)) {
            galeriaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}