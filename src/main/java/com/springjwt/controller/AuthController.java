package com.springjwt.controller;

import com.springjwt.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final TokenService tokenService;
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication)
    {
        log.debug("Token generated for user {}",authentication.getName());
        String token  = tokenService.generateToken(authentication);
        log.debug("token greanted is {}",token);
        return token;
    }
}
