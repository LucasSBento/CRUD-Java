package com.lucas.aprendizado.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="nome", nullable=false, length=100)
    private String nome;

    @Column(name="descricao", nullable=true)
    private String descricao;

    @Column(name="criacao")
    private LocalDate criacao;

    @ManyToMany
    @JoinTable(
        name="aluno_curso",
        joinColumns= @JoinColumn(name="produto_id"),
        inverseJoinColumns= @JoinColumn(name="usuario_id")
    )
    private Set<Usuario> usuarios = new HashSet<>();

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, LocalDate criacao, Set<Usuario> usuarios) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.criacao = LocalDate.now();
        this.usuarios = usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getCriacao() {
        return criacao;
    }

    public void setCriacao(LocalDate criacao) {
        this.criacao = criacao;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
}
