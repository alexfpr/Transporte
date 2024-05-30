// src/main/java/com/proyectoalex/app/controller/PaqueteController.java
package com.proyectoalex.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.proyectoalex.app.entidad.Paquete;
import com.proyectoalex.app.repository.PaqueteRepository;

@Controller
@RequestMapping("/paquetes")
public class PaqueteController {
    @Autowired
    private PaqueteRepository paqueteRepository;

    @GetMapping("/ListPaquete")
    public String listPaquetes(Model model) {
        model.addAttribute("paquetes", paqueteRepository.findAll());
        return "paquetes/list";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("paquete", new Paquete());
        return "paquetes/form";
    }

    @PostMapping("/nuevo")
    public String createPaquete(@ModelAttribute Paquete paquete) {
        paqueteRepository.save(paquete);
        return "redirect:/paquetes/ListPaquete";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("paquete", paqueteRepository.findById(id).orElseThrow());
        return "paquetes/form";
    }

    @PostMapping("/editar/{id}")
    public String updatePaquete(@PathVariable Long id, @ModelAttribute Paquete paqueteDetails) {
        Paquete paquete = paqueteRepository.findById(id).orElseThrow();
        paquete.setDescripcion(paqueteDetails.getDescripcion());
        paquete.setDestinatario(paqueteDetails.getDestinatario());
        paquete.setDireccion(paqueteDetails.getDireccion());
        paqueteRepository.save(paquete);
        return "redirect:/paquetes/ListPaquete";
    }

    @GetMapping("/eliminar/{id}")
    public String deletePaquete(@PathVariable Long id) {
        paqueteRepository.deleteById(id);
        return "redirect:/paquetes/ListPaquete";
    }
}
