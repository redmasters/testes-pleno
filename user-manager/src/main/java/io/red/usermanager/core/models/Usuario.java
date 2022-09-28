package io.red.usermanager.core.models;

import io.red.usermanager.app.controllers.v1.response.UsuarioResponse;
import io.red.usermanager.infra.entities.UsuarioEntity;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

public class Usuario {
    @Nullable
    private Long id;
    private String nome;
    private String nomeUsuario;
    private String email;
    private String senha;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Usuario() {
    }

    public Usuario(String nome, String nomeUsuario, String senha) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public Usuario(@Nullable Long id, String nome, String nomeUsuario, String senha, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    public Usuario(String nome, String nomeUsuario, String email, String senha) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioEntity toEntity(@Nullable Long id, String nome, String nomeUsuario, String senha, LocalDateTime dataCriacao) {
        return new UsuarioEntity(
                this.id = id,
                this.nome = nome,
                this.nomeUsuario = nomeUsuario,
                this.senha = senha,
                this.dataCriacao = dataCriacao
        );
    }

    public UsuarioEntity toEntity(String nome, String nomeUsuario, String senha) {
        return new UsuarioEntity(
                this.nome = nome,
                this.nomeUsuario = nomeUsuario,
                this.senha = senha
        );
    }


    public String getEmail() {
        return email;
    }

    @Nullable
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }


    public UsuarioResponse toResponse() {
        return new UsuarioResponse(
                this.id,
                this.nome,
                this.nomeUsuario,
                this.dataCriacao
        );
    }
}
