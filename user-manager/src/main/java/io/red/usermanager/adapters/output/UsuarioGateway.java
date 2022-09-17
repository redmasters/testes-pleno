package io.red.usermanager.adapters.output;

import io.red.usermanager.domain.entities.Usuario;
import io.red.usermanager.domain.usecases.port.UsuarioRepository;

public class UsuarioGateway implements UsuarioRepository {
    @Override
    public Usuario listar() {
        return new Usuario.UsuarioBuilder()
                .nomeUsuario("red")
                .nome("Erasmo")
                .build();
    }

    @Override
    public void criar(Usuario usuario) {
        Usuario novoUsuario = new Usuario.UsuarioBuilder()
                .nomeUsuario(usuario.getNomeUsuario())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .build();
        System.out.println("Usuario: " + novoUsuario + "criado");
    }
}
