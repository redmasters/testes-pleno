package io.red.usermanager.core.models;

import io.red.usermanager.app.controllers.v1.response.UsuarioResponse;
import io.red.usermanager.infra.entities.UsuarioEntity;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Usuario {
    @Nullable
    private Long id;
    private String nome;
    private String nomeUsuario;
    private String email;
    private String senha;
    private Collection<Perfil> perfil = new ArrayList<>();
    private boolean ativo = true;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Usuario() {
    }

    public Usuario(@Nullable Long id, String nome, String nomeUsuario, String email, String senha,
                   Collection<Perfil> perfil, boolean ativo, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
    }

    public Usuario(@Nullable Long id, String nome, String nomeUsuario, String email, String senha, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    public Usuario(String nome, String nomeUsuario, String email, String senha) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(@Nullable Long id, String nome, String nomeUsuario, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioEntity toEntity(String nome, String nomeUsuario, String email, String senha) {
        return new UsuarioEntity(
                this.nome = nome,
                this.nomeUsuario = nomeUsuario,
                this.email = email,
                this.senha = senha
        );
    }

    public UsuarioResponse toResponse() {
        return new UsuarioResponse(
                this.id,
                this.nome,
                this.nomeUsuario,
                this.email,
                this.dataCriacao,
                this.perfil
        );
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

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Collection<Perfil> getFuncao() {
        return perfil;
    }
}
