package com.lucas.aprendizado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.aprendizado.models.Usuario;
import com.lucas.aprendizado.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    public UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscar(Long id){
        return usuarioRepository.findById(id).get();
    }

    public boolean atualizar(Long id, Usuario usuario){
        if(usuarioRepository.existsById(id)){
            usuario.setId(id);
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    public boolean deletar(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
