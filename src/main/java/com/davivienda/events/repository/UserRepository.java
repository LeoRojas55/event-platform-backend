package com.davivienda.events.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davivienda.events.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Buscar usuario por nombre de usuario
    Optional<User> findByUsername(String username);

    // Verificar si existe un nombre de usuario
    boolean existsByUsername(String username);

    // Buscar usuario por correo (si aplica)
    Optional<User> findByEmail(String email);

    // Verificar si existe un correo registrado
    boolean existsByEmail(String email);
} 