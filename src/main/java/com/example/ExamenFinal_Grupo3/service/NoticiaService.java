package com.example.ExamenFinal_Grupo3.service;

import com.example.ExamenFinal_Grupo3.entity.Noticia;
import com.example.ExamenFinal_Grupo3.repository.NoticiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

	private final NoticiaRepository noticiaRepository;

	public NoticiaService(NoticiaRepository noticiaRepository) {
		this.noticiaRepository = noticiaRepository;
	}

	public List<Noticia> listarNoticias() {
		return noticiaRepository.findAll();
	}

	public Optional<Noticia> buscarPorId(Long id) {
		return noticiaRepository.findById(id);
	}

	public Noticia guardarNoticia(Noticia noticia) {
		return noticiaRepository.save(noticia);
	}

	public Optional<Noticia> actualizarNoticia(Long id, Noticia noticiaActualizada) {
		return noticiaRepository.findById(id).map(noticiaExistente -> {
			noticiaExistente.setTitulo(noticiaActualizada.getTitulo());
			noticiaExistente.setDescripcion(noticiaActualizada.getDescripcion());
			noticiaExistente.setFecha(noticiaActualizada.getFecha());
			noticiaExistente.setImagenUrl(noticiaActualizada.getImagenUrl());
			noticiaExistente.setCategoria(noticiaActualizada.getCategoria());

			return noticiaRepository.save(noticiaExistente);
		});
	}

	public boolean eliminarNoticia(Long id) {
		if (noticiaRepository.existsById(id)) {
			noticiaRepository.deleteById(id);
			return true;
		}

		return false;
	}
}