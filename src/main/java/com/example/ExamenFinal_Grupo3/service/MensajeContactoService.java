package com.example.ExamenFinal_Grupo3.service;

import com.example.ExamenFinal_Grupo3.entity.MensajeContacto;
import com.example.ExamenFinal_Grupo3.repository.MensajeContactoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeContactoService {

    private final MensajeContactoRepository mensajeContactoRepository;

    public MensajeContactoService(MensajeContactoRepository mensajeContactoRepository) {
        this.mensajeContactoRepository = mensajeContactoRepository;
    }

    public List<MensajeContacto> listarMensajes() {
        return mensajeContactoRepository.findAll();
    }

    public Optional<MensajeContacto> buscarPorId(Long id) {
        return mensajeContactoRepository.findById(id);
    }

    public MensajeContacto guardarMensaje(MensajeContacto mensajeContacto) {
        return mensajeContactoRepository.save(mensajeContacto);
    }

    public Optional<MensajeContacto> actualizarMensaje(Long id, MensajeContacto mensajeActualizado) {
        return mensajeContactoRepository.findById(id).map(mensajeExistente -> {
            mensajeExistente.setNombre(mensajeActualizado.getNombre());
            mensajeExistente.setCorreo(mensajeActualizado.getCorreo());
            mensajeExistente.setAsunto(mensajeActualizado.getAsunto());
            mensajeExistente.setMensaje(mensajeActualizado.getMensaje());
            mensajeExistente.setEstado(mensajeActualizado.getEstado());

            return mensajeContactoRepository.save(mensajeExistente);
        });
    }

    public boolean eliminarMensaje(Long id) {
        if (mensajeContactoRepository.existsById(id)) {
            mensajeContactoRepository.deleteById(id);
            return true;
        }

        return false;
    }
}