package com.umg.registro_estudiantes.service;

import com.umg.registro_estudiantes.dto.EstudianteRequestDTO;
import com.umg.registro_estudiantes.entity.Estudiante;
import com.umg.registro_estudiantes.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    @Autowired
    private RecaptchaService recaptchaService;

    public Estudiante registrar(EstudianteRequestDTO dto) {
        // 1. Validar reCAPTCHA
        if (!recaptchaService.verificarToken(dto.getRecaptchaToken())) {
            throw new RuntimeException("Validación de reCAPTCHA fallida");
        }

        // 2. Validar edad (16 años)
        int edad = Period.between(dto.getFechaNacimiento(), LocalDate.now()).getYears();
        if (edad < 16) {
            throw new RuntimeException("El estudiante debe tener al menos 16 años");
        }

        // 3. Validar duplicado
        if (repository.existsByCarne(dto.getCarne())) {
            throw new RuntimeException("El carné ya está registrado");
        }

        // 4. Mapear y guardar
        Estudiante est = new Estudiante();
        est.setCarne(dto.getCarne());
        est.setNombres(dto.getNombres());
        est.setApellidos(dto.getApellidos());
        est.setCorreo(dto.getCorreo());
        est.setCarrera(dto.getCarrera());
        est.setTelefono(dto.getTelefono());
        est.setFechaNacimiento(dto.getFechaNacimiento());
        est.setGenero(dto.getGenero());

        return repository.save(est);
    }

    public List<Estudiante> listarTodos() {
        return repository.findAll();
    }
}