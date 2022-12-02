package io.red.usermanager.infra.entities;

import io.red.usermanager.core.models.Usuario;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "manager_usuario")
public class UsuarioEntity {
    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String nomeUsuario;
    private String email;
    private String senha;

    @OneToMany(fetch = EAGER)
    private Collection<PerfilEntity> perfil = new ArrayList<>();
    private boolean ativo = true;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public UsuarioEntity() {
    }

    public UsuarioEntity(@Nullable Long id, String nome, String nomeUsuario, String email, String senha, boolean ativo, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
    }

    public UsuarioEntity(String nome, String nomeUsuario, String email, String senha) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioEntity(@Nullable Long id, String nome, String nomeUsuario, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioEntity(@Nullable Long id,
                         String nome, String nomeUsuario,
                         String email, String senha, Collection<PerfilEntity> perfil, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.dataCriacao = dataCriacao;
    }

      public UsuarioEntity toEntity(Long id, String nome, String nomeUsuario, String email, String senha) {
        return new UsuarioEntity(
                this.id = id,
                this.nome = nome,
                this.nomeUsuario = nomeUsuario,
                this.email = email,
                this.senha = senha
        );


    }

    public UsuarioEntity toDelete(Long id, String nome,
                                  String nomeUsuario,
                                  String email,
                                  String senha,
                                  boolean ativo,
                                  LocalDateTime dataCriacao) {
        return new UsuarioEntity(
                this.id = id,
                this.nome = nome,
                this.nomeUsuario = nomeUsuario,
                this.email = email,
                this.senha = senha,
                this.ativo = ativo,
                this.dataCriacao = dataCriacao
        );
    }


    public Usuario toModel() {
        return new Usuario(
                this.id,
                this.nome,
                this.nomeUsuario,
                this.email,
                this.senha,
                this.perfil,
                this.dataCriacao
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

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Collection<PerfilEntity> getPerfil() {
        return perfil;
    }
}
