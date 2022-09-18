package io.red.usermanager.adapters.output;

import io.red.usermanager.domain.entities.Usuario;
import io.red.usermanager.domain.usecases.port.UsuarioRepository;
import io.red.usermanager.domain.usecases.validator.ValidacaoUsuario;

public class UsuarioGateway implements UsuarioRepository {
    @Override
    public Usuario listar() {
        return new Usuario.UsuarioBuilder()
                .nomeUsuario("red")
                .nome("Erasmo")
                .build();
    }

    @Override
    public Usuario criar(Usuario usuario) {
        ValidacaoUsuario.validarCriacaoUsuario(usuario);

        return new Usuario.UsuarioBuilder()
                .nomeUsuario(usuario.getNomeUsuario())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .build();
    }

}
