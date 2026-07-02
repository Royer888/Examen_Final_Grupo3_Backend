package com.example.ExamenFinal_Grupo3.controller;

import com.example.ExamenFinal_Grupo3.entity.MensajeContacto;
import com.example.ExamenFinal_Grupo3.service.MensajeContactoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    private final MensajeContactoService mensajeContactoService;

    public ContactoController(MensajeContactoService mensajeContactoService) {
        this.mensajeContactoService = mensajeContactoService;
    }

    @GetMapping
    public List<MensajeContacto> listarMensajes() {
        return mensajeContactoService.listarMensajes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MensajeContacto> buscarPorId(@PathVariable Long id) {
        return mensajeContactoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MensajeContacto> guardarMensaje(@RequestBody MensajeContacto mensajeContacto) {
        MensajeContacto nuevoMensaje = mensajeContactoService.guardarMensaje(mensajeContacto);
        return ResponseEntity.ok(nuevoMensaje);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MensajeContacto> actualizarMensaje(
            @PathVariable Long id,
            @RequestBody MensajeContacto mensajeContacto) {

        return mensajeContactoService.actualizarMensaje(id, mensajeContacto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable Long id) {
        boolean eliminado = mensajeContactoService.eliminarMensaje(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}