package io.red.usermanager.infra.repositories;

import io.red.usermanager.app.controllers.v1.request.EditarUsuarioRequest;
import io.red.usermanager.core.exceptions.UsuarioException;
import io.red.usermanager.core.exceptions.ValidacaoUsuarioException;
import io.red.usermanager.core.models.Usuario;
import io.red.usermanager.core.repositories.UsuarioRepository;
import io.red.usermanager.core.validator.ValidaUsuario;
import io.red.usermanager.infra.entities.UsuarioEntity;
import io.red.usermanager.infra.repositories.jpa.UsuarioJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepositoryImpl.class);
    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioRepositoryImpl(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        ValidaUsuario.validarCriacaoUsuario(usuario);
        final var isUsuario = usuarioJpaRepository.findAllByNomeUsuario(usuario.getNomeUsuario());
        final var isEmail = usuarioJpaRepository.findAllByEmail(usuario.getEmail());

        if (isUsuario.isPresent()) {
            throw new ValidacaoUsuarioException(usuario.getNomeUsuario() + " ja esta em uso.");
        }

        if (isEmail.isPresent()) {
            throw new ValidacaoUsuarioException(usuario.getEmail() + " esta em uso.");
        }

        final var usuarioEntity = usuario.toEntity(
                usuario.getNome(),
                usuario.getNomeUsuario(),
                usuario.getEmail(),
                usuario.getSenha()
        );
        LOGGER.info("Salvando usuario {}", usuario.getNomeUsuario());
        return usuarioJpaRepository.save(usuarioEntity).toModel();
    }

    @Override
    public List<Usuario> listarTodos() {
        final var usuarios = usuarioJpaRepository.findAll();

        List<Usuario> usuarioList = new ArrayList<>();
        usuarios.forEach(usuario -> {
            usuarioList.add(usuario.toModel());
            LOGGER.info("Listando usuario: {}", usuario.getNomeUsuario());
        });

        LOGGER.info("Listando todos os usuarios com o metodo 'listarTodos()'");
        return usuarioList;
    }

    @Override
    public Usuario buscarPor(Long id) {
        final var usuario = usuarioJpaRepository.findById(id)
                .orElseThrow(() -> new UsuarioException("Usuario com id " + id + " nao encontrado"));
        LOGGER.info("Exibindo usuario de id: {} - {}", id, usuario.getNomeUsuario());
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

        LOGGER.info("Editando usuario: id: {} - {}", usuarioEditado.getId(), usuarioEditado.getNomeUsuario());
        return usuarioJpaRepository.save(novoUsuario).toModel();

    }

    @Override
    public void delecaoLogicaPor(Long id, boolean ativo) {
        final var usuario = usuarioJpaRepository
                .findById(id)
                .orElseThrow(() -> new UsuarioException("Usuario nao encontrado"));

        final var deletado = new UsuarioEntity().toDelete(
                usuario.getId(),
                usuario.getNome(),
                usuario.getNomeUsuario(),
                usuario.getEmail(),
                usuario.getSenha(),
                false,
                usuario.getDataCriacao()
        );
        LOGGER.info("Deletando usuario: id {} - {}", usuario.getId(), usuario.getNomeUsuario());
        usuarioJpaRepository.save(deletado);

    }

}
