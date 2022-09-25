package io.red.usermanager.infra.repositories;

import io.red.usermanager.core.models.Usuario;
import io.red.usermanager.core.repositories.UsuarioRepository;
import io.red.usermanager.infra.repositories.jpa.UsuarioJpaRepository;

public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioRepositoryImpl(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        final var usuarioEntity = usuario.toEntity(
                usuario.getNomeUsuario(),
                usuario.getNome(),
                usuario.getSenha()
        );
        return usuarioJpaRepository.save(usuarioEntity).toModel();
    }

}
