package com.example.ExamenFinal_Grupo3.controller;

import com.example.ExamenFinal_Grupo3.entity.Docente;
import com.example.ExamenFinal_Grupo3.service.DocenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping
    public List<Docente> listarDocentes() {
        return docenteService.listarDocentes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> buscarPorId(@PathVariable Long id) {
        return docenteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Docente> guardarDocente(@RequestBody Docente docente) {
        Docente nuevoDocente = docenteService.guardarDocente(docente);
        return ResponseEntity.ok(nuevoDocente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Docente> actualizarDocente(
            @PathVariable Long id,
            @RequestBody Docente docente) {

        return docenteService.actualizarDocente(id, docente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable Long id) {
        boolean eliminado = docenteService.eliminarDocente(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}