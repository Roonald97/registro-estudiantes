package com.umg.registro_estudiantes.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.Map;

@Service
public class RecaptchaService {
    private static final String SECRET_KEY = "TU_SECRET_KEY_DE_GOOGLE"; // Reemplazar
    private static final String VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    public boolean verificarToken(String token) {
        RestTemplate restTemplate = new RestTemplate();
        String params = "?secret=" + SECRET_KEY + "&response=" + token;
        ResponseEntity<Map> response = restTemplate.postForEntity(VERIFY_URL + params, null, Map.class);
        Map<String, Object> body = response.getBody();
        return body != null && (Boolean) body.get("success");
    }
}