package com.cmuniz.mylogapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public void registerUser(String username) {
        logger.info("Tentativa de Registrar user: {}", username);
       try {
            if (username.length() < 3) {
                logger.error("Falha no registro do user '{}'. Username deve ter 3 caracteres no mínimo.", username);
                throw new IllegalArgumentException("Username é muito curto.");
            }
            logger.info("User '{}' registrado com sucesso.", username);
        } catch (Exception e) {
            logger.error("Uma falha ocorreu no durante o registro de utilizador..", e);
            throw e;
        }
    }
}
