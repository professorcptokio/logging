package com.cmuniz.mylogapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cmuniz.mylogapp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @GetMapping("/")
    public ResponseEntity<String> register(@RequestParam String username) {
      logger.debug("Recebida requisição para registrar user: {}", username);

        try {
            service.registerUser(username);
            return ResponseEntity.ok("user registrado com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao processar registro para user '{}'", username, e);
            return ResponseEntity.badRequest().body("Falha ao registrar o user: " + e.getMessage());
        } 
    }
    

}
