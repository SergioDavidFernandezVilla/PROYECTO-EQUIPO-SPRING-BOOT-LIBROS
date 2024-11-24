package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.LibroModel;

public interface LibroRepository extends JpaRepository<LibroModel, Long> {
        
}
