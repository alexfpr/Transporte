// src/main/java/com/proyectoalex/app/repository/PaqueteRepository.java
package com.proyectoalex.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectoalex.app.entidad.Paquete;

public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
}
