package com.lucas.aprendizado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.aprendizado.models.Usuario;

@Repository
public interface UsuarioRepositorie extends JpaRepository<Usuario, Long> {
    
}
