package io.red.usermanager.infra.repositories;

import io.red.usermanager.core.exceptions.UsuarioException;
import io.red.usermanager.core.models.Usuario;
import io.red.usermanager.core.models.UsuarioFilter;
import io.red.usermanager.core.repositories.UsuarioRepository;
import io.red.usermanager.core.validator.ValidaUsuario;
import io.red.usermanager.infra.repositories.jpa.UsuarioJpaRepository;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioRepositoryImpl(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        ValidaUsuario.validarCriacaoUsuario(usuario);
        final var isUsuario = usuarioJpaRepository.existsByNomeUsuario(usuario.getNomeUsuario());
        final var isEmail = usuarioJpaRepository.existsByEmail(usuario.getEmail());

        if(isUsuario.isPresent()){
            throw new UsuarioException("Nome de usuario ja existe");
        }

        if(isEmail.isPresent()){
            throw new UsuarioException("Email em uso");
        }

        final var usuarioEntity = usuario.toEntity(
                usuario.getNomeUsuario(),
                usuario.getNome(),
                usuario.getSenha()
        );
        return usuarioJpaRepository.save(usuarioEntity).toModel();
    }

    @Override
    public List<Usuario> listarTodos() {
        final var usuarios = usuarioJpaRepository.findAll();

        List<Usuario> usuarioList = new ArrayList<>();
        usuarios.forEach(usuario -> {
            usuarioList.add(usuario.toModel());
        });
        return usuarioList;
    }

}