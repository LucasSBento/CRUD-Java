package com.lucas.aprendizado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.aprendizado.models.Usuario;
import com.lucas.aprendizado.services.UsuarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    public UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario){
        return usuarioService.cadastrar(usuario);
    }

    @GetMapping("/buscar{id}")
    public Usuario buscar(@RequestParam Long id){
        return usuarioService.buscar(id);
    }

    @PutMapping("/atualizar{id}")
    public boolean atualizar(@RequestParam Long id, @RequestBody Usuario usuario){
        return usuarioService.atualizar(id, usuario);
    }

    @DeleteMapping("/deletar{id}")
    public String deletar(@RequestParam Long id){
        boolean deletou = usuarioService.deletar(id);
        if(deletou){
            return "Deletado";
        }
        return "Usuário não encontrado";
    }

}
