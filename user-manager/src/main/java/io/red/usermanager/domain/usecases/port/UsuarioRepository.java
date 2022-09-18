package io.red.usermanager.domain.usecases.port;

import io.red.usermanager.domain.entities.Usuario;

public interface UsuarioRepository {

    Usuario listar();
    Usuario criar(Usuario usuario);

}
