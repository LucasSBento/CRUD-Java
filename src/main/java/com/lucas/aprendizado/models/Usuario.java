package com.lucas.aprendizado.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="cpf", nullable=false, unique=true)
    private String cpf;

    @Column(name="data_nascimento", nullable=false)
    private LocalDate dataNascimento;

    @Column(name="telefone", nullable=false)
    private String telefone;

    @Column(name="senha", nullable=false)
    private String senha;

    @Column(name="criacao")
    private LocalDate criacao;

    @ManyToMany(mappedBy = "cursos")
    private Set<Produto> produtos = new HashSet<>();

    public Usuario() {
    }

    public Usuario(int id, String nome, String cpf, LocalDate dataNascimento, String telefone, String senha,
            LocalDate criacao, Set<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.senha = senha;
        this.criacao = LocalDate.now();
        this.produtos = produtos;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getCriacao() {
        return criacao;
    }

    public void setCriacao(LocalDate criacao) {
        this.criacao = criacao;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    
}
