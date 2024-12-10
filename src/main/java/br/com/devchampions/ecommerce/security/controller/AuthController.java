package br.com.devchampions.ecommerce.security.controller;

import br.com.devchampions.ecommerce.security.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    JwtService jwtService;

    @PostMapping("/authenticate")
    public String authenticate(Authentication authentication) {

        log.info("Auth: {}", authentication.getPrincipal().toString());


        return jwtService.token(authentication);
    }

}