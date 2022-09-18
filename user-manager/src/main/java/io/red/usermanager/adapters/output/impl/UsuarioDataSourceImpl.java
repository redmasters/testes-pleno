package io.red.usermanager.adapters.output.impl;

import io.red.usermanager.adapters.output.JpaH2UsuarioRepository;
import io.red.usermanager.adapters.output.models.UsuarioModel;
import io.red.usermanager.adapters.repository.h2Repository.UsuarioDataSourceLocal;
import io.red.usermanager.domain.entities.Usuario;
import org.w3c.dom.css.ViewCSS;

public class UsuarioDataSourceImpl implements UsuarioDataSourceLocal{

    private final JpaH2UsuarioRepository jpaH2UsuarioRepository;
    public UsuarioDataSourceImpl(JpaH2UsuarioRepository jpaH2UsuarioRepository) {
        this.jpaH2UsuarioRepository = jpaH2UsuarioRepository;
    }

    @Override
    public void criar(UsuarioModel usuario) {
        final var usuarioModel = new UsuarioModel(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getNomeUsuario()

        );
        jpaH2UsuarioRepository.save(usuarioModel);
    }
}
