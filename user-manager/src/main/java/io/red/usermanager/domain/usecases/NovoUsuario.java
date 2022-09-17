package io.red.usermanager.domain.usecases;

import io.red.usermanager.domain.entities.Usuario;
import io.red.usermanager.domain.usecases.port.UsuarioRepository;

public class NovoUsuario {
    private final UsuarioRepository usuarioRepository;

    public NovoUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void criar(final Usuario usuario) {
       usuarioRepository.criar(usuario);
    }
}
