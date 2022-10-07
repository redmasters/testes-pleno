package io.red.usermanager.infra.repositories;

import io.red.usermanager.app.controllers.v1.request.EditarUsuarioRequest;
import io.red.usermanager.core.exceptions.UsuarioException;
import io.red.usermanager.core.exceptions.ValidacaoUsuarioException;
import io.red.usermanager.core.models.Usuario;
import io.red.usermanager.core.repositories.UsuarioRepository;
import io.red.usermanager.core.validator.ValidaUsuario;
import io.red.usermanager.infra.entities.UsuarioEntity;
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
        final var isUsuario = usuarioJpaRepository.findAllByNomeUsuario(usuario.getNomeUsuario());
        final var isEmail = usuarioJpaRepository.findAllByEmail(usuario.getEmail());

        if(isUsuario.isPresent()){
            throw new ValidacaoUsuarioException(usuario.getNomeUsuario() + " ja esta em uso.");
        }

        if(isEmail.isPresent()){
            throw new ValidacaoUsuarioException(usuario.getEmail() + " esta em uso.");
        }

        final var usuarioEntity = usuario.toEntity(
                usuario.getNome(),
                usuario.getNomeUsuario(),
                usuario.getEmail(),
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

    @Override
    public Usuario buscarPor(Long id) {
        final var usuario = usuarioJpaRepository.findById(id)
                .orElseThrow(() -> new UsuarioException("Usuario com id " + id + " nao encontrado"));
        return usuario.toModel();
    }

    @Override
    public Usuario editar(EditarUsuarioRequest request) {
        final var usuarioEditado = usuarioJpaRepository
                .findById(request.id())
                .orElseThrow(() -> new UsuarioException("Usuario nao encontrado"));

        var novoUsuario = new UsuarioEntity().toEntity(
                usuarioEditado.getId(),
                request.nome(),
                request.nomeUsuario(),
                request.email(),
                request.senha()
        );

        return usuarioJpaRepository.save(novoUsuario).toModel();

    }

    @Override
    public void delecaoLogicaPor(Long id, boolean excluido) {
        final var usuario = usuarioJpaRepository
                .findById(id)
                .orElseThrow(() -> new UsuarioException("Usuario nao encontrado"));

        final var deletado = new UsuarioEntity().toDelete(
                usuario.getId(),
                excluido
        );
        usuarioJpaRepository.save(deletado);

    }

}
