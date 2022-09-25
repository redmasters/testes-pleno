package io.red.usermanager.core.usecases;

import io.red.usermanager.core.models.Usuario;
import io.red.usermanager.core.repositories.UsuarioRepository;

public class CriarUsuario {
    private final UsuarioRepository usuarioRepository;

    public CriarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criar(Usuario usuario){
        return usuarioRepository.salvar(usuario);
    }
}
