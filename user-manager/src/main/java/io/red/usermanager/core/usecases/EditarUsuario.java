package io.red.usermanager.core.usecases;

import io.red.usermanager.app.controllers.v1.request.EditarUsuarioRequest;
import io.red.usermanager.core.models.Usuario;
import io.red.usermanager.core.repositories.UsuarioRepository;

public class EditarUsuario {
    private UsuarioRepository usuarioRepository;

    public EditarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario atualizar(EditarUsuarioRequest editarUsuarioRequest) {
        return usuarioRepository.editar(editarUsuarioRequest);
    }
}
