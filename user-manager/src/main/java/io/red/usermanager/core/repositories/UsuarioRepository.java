package io.red.usermanager.core.repositories;

import io.red.usermanager.core.models.Usuario;
import io.red.usermanager.core.models.UsuarioFilter;

import java.util.List;

public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);
    List<Usuario> listarTodos();
    Usuario buscarPor(Long id);
}
