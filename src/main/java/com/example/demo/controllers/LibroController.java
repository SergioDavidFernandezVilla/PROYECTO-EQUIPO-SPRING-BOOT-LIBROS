package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.LibroModel;
import com.example.demo.services.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroModel> obtenerLibroPorId(@PathVariable Long id) {
        return libroService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/obtener-todos")
    public ResponseEntity<Iterable<LibroModel>> obtenerTodosLosLibros() {
        Iterable<LibroModel> libros = libroService.getAllBooks();
        return ResponseEntity.ok(libros);
    }

    @PostMapping("/crear-libro")
    public ResponseEntity<LibroModel> crearLibro(@RequestBody LibroModel libro) {
        LibroModel nuevoLibro = libroService.createBook(libro);
        return ResponseEntity.ok(nuevoLibro);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
