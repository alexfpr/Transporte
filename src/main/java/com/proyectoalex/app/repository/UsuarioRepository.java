// src/main/java/com/proyectoalex/app/repository/UsuarioRepository.java
package com.proyectoalex.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectoalex.app.entidad.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
