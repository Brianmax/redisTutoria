package com.example.demo2.repository;

import com.example.demo2.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByNumeroDocumento(String dni);
}
