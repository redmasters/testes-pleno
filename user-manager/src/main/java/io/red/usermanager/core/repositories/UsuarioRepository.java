package io.red.usermanager.core.repositories;

import io.red.usermanager.app.controllers.v1.request.EditarUsuarioRequest;
import io.red.usermanager.core.models.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario buscarPor(Long id);

    Usuario editar(EditarUsuarioRequest editarUsuarioRequest);

    void delecaoLogicaPor(Long id, boolean exluido);
}
