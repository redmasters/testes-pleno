package io.red.usermanager.domain.usecases;

import io.red.usermanager.domain.entities.Usuario;

public class NovoUsuario {

    public Usuario criar(Usuario usuario){
        Usuario novoUsuario = new Usuario.UsuarioBuilder()
                .nomeUsuario(usuario.getNomeUsuario())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .build();
        System.out.println(novoUsuario);
        return novoUsuario;
    }
}
