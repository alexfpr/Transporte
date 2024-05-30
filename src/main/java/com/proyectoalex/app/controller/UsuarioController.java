// src/main/java/com/proyectoalex/app/controller/UsuarioController.java
package com.proyectoalex.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.proyectoalex.app.entidad.Usuario;
import com.proyectoalex.app.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/ListUsuarios")
    public String listUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios/list";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }

    @PostMapping("/nuevo")
    public String createUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuarios/ListUsuarios";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", usuarioRepository.findById(id).orElseThrow());
        return "usuarios/form";
    }

    @PostMapping("/editar/{id}")
    public String updateUsuario(@PathVariable Long id, @ModelAttribute Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setEmail(usuarioDetails.getEmail());
        usuarioRepository.save(usuario);
        return "redirect:/usuarios/ListUsuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios/ListUsuarios";
    }
}
