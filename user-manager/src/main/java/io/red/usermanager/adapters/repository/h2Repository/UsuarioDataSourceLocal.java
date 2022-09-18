package io.red.usermanager.adapters.repository.h2Repository;

import io.red.usermanager.adapters.output.models.UsuarioModel;
import io.red.usermanager.domain.entities.Usuario;

public interface UsuarioDataSourceLocal {
    void criar(UsuarioModel usuario);
}
