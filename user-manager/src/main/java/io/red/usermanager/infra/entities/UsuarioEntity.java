package io.red.usermanager.infra.entities;

import io.red.usermanager.core.models.Usuario;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "um_usuario")
public class UsuarioEntity {
    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String nomeUsuario;
    private String email;
    private String senha;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public UsuarioEntity() {
    }

    public UsuarioEntity(String nome, String nomeUsuario, String senha) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }



    public UsuarioEntity(@Nullable Long id, String nome, String nomeUsuario, String senha, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    public Usuario toModel() {
        return new Usuario(
                this.id,
                this.nome,
                this.nomeUsuario,
                this.senha,
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
}
