package io.red.usermanager.adapters.output.models;

import io.red.usermanager.domain.entities.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String nomeUsuario;

    public Usuario toUsuario(UsuarioModel usuarioModel) {
        return new Usuario(
                usuarioModel.getId(),
                usuarioModel.getNome(),
                usuarioModel.getEmail(),
                usuarioModel.getSenha(),
                usuarioModel.getNomeUsuario()
        );
    }

    public UsuarioModel toModel(Usuario usuario) {
        return new UsuarioModel(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getNomeUsuario()
        );
    }

    public UsuarioModel() {
    }

    public UsuarioModel(Long id, String nome, String email, String senha, String nomeUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
