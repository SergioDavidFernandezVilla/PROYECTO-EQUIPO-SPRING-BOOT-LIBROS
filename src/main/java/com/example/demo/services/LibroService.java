package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.LibroModel;
import com.example.demo.repositories.LibroRepository;

import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    // Crear un libro
    public LibroModel createBook(LibroModel libro) {
        return repository.save(libro);
    }

    // Obtener un libro por ID
    public Optional<LibroModel> getBookById(Long id) {
        return repository.findById(id);
    }

    // Obtener todos los libros
    public Iterable<LibroModel> getAllBooks() {
        return repository.findAll();
    }

    // Eliminar libro por id
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    // Actulizar libro por id
    public LibroModel updateBook(LibroModel libro) {
        return repository.save(libro);
    }
}
