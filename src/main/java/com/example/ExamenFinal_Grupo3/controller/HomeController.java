package com.example.ExamenFinal_Grupo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Backend Colegio Carlos Medinaceli funcionando correctamente";
    }

    @GetMapping("/api/test")
    public String test() {
        return "API funcionando correctamente";
    }
}