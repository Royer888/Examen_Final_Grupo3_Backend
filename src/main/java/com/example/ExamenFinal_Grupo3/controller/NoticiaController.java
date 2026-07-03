package com.example.ExamenFinal_Grupo3.controller;

import com.example.ExamenFinal_Grupo3.entity.Noticia;
import com.example.ExamenFinal_Grupo3.service.NoticiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

	private final NoticiaService noticiaService;

	public NoticiaController(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}

	@GetMapping
	public List<Noticia> listarNoticias() {
		return noticiaService.listarNoticias();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Noticia> buscarPorId(@PathVariable Long id) {
		return noticiaService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Noticia> guardarNoticia(@RequestBody Noticia noticia) {
		Noticia nuevaNoticia = noticiaService.guardarNoticia(noticia);
		return ResponseEntity.ok(nuevaNoticia);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Noticia> actualizarNoticia(
			@PathVariable Long id,
			@RequestBody Noticia noticia) {

		return noticiaService.actualizarNoticia(id, noticia)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarNoticia(@PathVariable Long id) {
		boolean eliminado = noticiaService.eliminarNoticia(id);

		if (!eliminado) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
}