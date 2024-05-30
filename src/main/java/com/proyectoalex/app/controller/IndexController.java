package com.proyectoalex.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
    @GetMapping("/")
    public String index() {
        // Devolver la página de inicio
        return "index";
    }
}
