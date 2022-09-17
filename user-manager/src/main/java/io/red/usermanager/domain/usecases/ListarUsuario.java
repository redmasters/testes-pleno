package io.red.usermanager.domain.usecases;

import io.red.usermanager.domain.entities.Usuario;
import io.red.usermanager.domain.usecases.port.UsuarioRepository;

public class ListarUsuario {
    private final UsuarioRepository usuarioRepository;

    public ListarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario listar(){
        return usuarioRepository.listar();
    }

}
