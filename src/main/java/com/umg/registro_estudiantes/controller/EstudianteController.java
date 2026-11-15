package com.umg.registro_estudiantes.controller;

import com.umg.registro_estudiantes.dto.EstudianteRequestDTO;
import com.umg.registro_estudiantes.entity.Estudiante;
import com.umg.registro_estudiantes.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*") // Para permitir peticiones desde el frontend
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody EstudianteRequestDTO dto) {
        try {
            Estudiante nuevo = service.registrar(dto);
            return ResponseEntity.ok(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Estudiante> listar() {
        return service.listarTodos();
    }
}

//com.umg.registro_estudiantes