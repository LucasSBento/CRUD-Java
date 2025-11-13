package com.lucas.aprendizado.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.aprendizado.models.Produto;

@Repository
public interface ProdutoRepositorie extends JpaRepository<Produto, Long> {

    List<Produto> findByNome(String nome);
    
}
