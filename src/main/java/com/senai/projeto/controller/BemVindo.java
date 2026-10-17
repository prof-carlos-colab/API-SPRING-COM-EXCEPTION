package com.senai.projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BemVindo {
    // ENDPOINT
    @GetMapping
    public String mensagem() {
        return "Bem-vindo!";
    }

    // ENDPOINT
    @GetMapping("/dev")
    public String dev() {
        return "Feito por: Seu nome";
    }
}
