package com.example.ExamenFinal_Grupo3.controller;

import com.example.ExamenFinal_Grupo3.entity.Galeria;
import com.example.ExamenFinal_Grupo3.service.GaleriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/galeria")
public class GaleriaController {

    private final GaleriaService galeriaService;

    public GaleriaController(GaleriaService galeriaService) {
        this.galeriaService = galeriaService;
    }

    @GetMapping
    public List<Galeria> listarGaleria() {
        return galeriaService.listarGaleria();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Galeria> buscarPorId(@PathVariable Long id) {
        return galeriaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{categoria}")
    public List<Galeria> buscarPorCategoria(@PathVariable String categoria) {
        return galeriaService.buscarPorCategoria(categoria);
    }

    @PostMapping
    public ResponseEntity<Galeria> guardarGaleria(@RequestBody Galeria galeria) {
        Galeria nuevaGaleria = galeriaService.guardarGaleria(galeria);
        return ResponseEntity.ok(nuevaGaleria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Galeria> actualizarGaleria(
            @PathVariable Long id,
            @RequestBody Galeria galeria) {

        return galeriaService.actualizarGaleria(id, galeria)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGaleria(@PathVariable Long id) {
        boolean eliminado = galeriaService.eliminarGaleria(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}