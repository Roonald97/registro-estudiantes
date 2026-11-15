package com.umg.registro_estudiantes.repository;

import com.umg.registro_estudiantes.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    boolean existsByCarne(String carne);
}