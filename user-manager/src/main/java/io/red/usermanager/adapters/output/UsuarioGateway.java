package io.red.usermanager.adapters.output;

import io.red.usermanager.adapters.repository.h2Repository.UsuarioDataSourceLocal;
import io.red.usermanager.domain.entities.Usuario;
import io.red.usermanager.domain.usecases.port.UsuarioRepository;
import io.red.usermanager.domain.usecases.validator.ValidacaoUsuario;

public class UsuarioGateway implements UsuarioRepository {

    final UsuarioDataSourceLocal usuarioDataSourceLocal;

    public UsuarioGateway(UsuarioDataSourceLocal usuarioDataSourceLocal) {
        this.usuarioDataSourceLocal = usuarioDataSourceLocal;
    }

    @Override
    public Usuario listar() {
        return new Usuario.UsuarioBuilder()
                .nomeUsuario("red")
                .nome("Erasmo")
                .build();
    }

    @Override
    public void criar(Usuario usuario) {
        ValidacaoUsuario.validarCriacaoUsuario(usuario);
        final var novoUsuario = new Usuario.UsuarioBuilder()
                .nomeUsuario(usuario.getNomeUsuario())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .build();
    }

}
