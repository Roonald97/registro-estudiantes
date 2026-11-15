package com.umg.registro_estudiantes.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class EstudianteRequestDTO {

    @NotBlank(message = "El carné es requerido")
    @Size(min = 8, max = 8, message = "El carné debe tener exactamente 8 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El carné solo debe ser alfanumérico")
    private String carne;

    @NotBlank(message = "Los nombres son requeridos")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "Solo letras y espacios")
    private String nombres;

    @NotBlank(message = "Los apellidos son requeridos")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "Solo letras y espacios")
    private String apellidos;

    @NotBlank(message = "El correo es requerido")
    @Email(message = "Formato de correo inválido")
    private String correo;

    @NotBlank(message = "La carrera es requerida")
    private String carrera;

    @NotBlank(message = "El teléfono es requerido")
    @Pattern(regexp = "^\\d{4}-\\d{4}$", message = "Formato requerido: ####-####")
    private String telefono;

    @NotNull(message = "La fecha de nacimiento es requerida")
    @Past(message = "La fecha debe ser pasada")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El género es requerido")
    @Pattern(regexp = "masculino|femenino|otro", message = "Género inválido")
    private String genero;

    @NotBlank(message = "El token de reCAPTCHA es requerido")
    private String recaptchaToken;

    // ===== Getters y Setters =====

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRecaptchaToken() {
        return recaptchaToken;
    }

    public void setRecaptchaToken(String recaptchaToken) {
        this.recaptchaToken = recaptchaToken;
    }
}