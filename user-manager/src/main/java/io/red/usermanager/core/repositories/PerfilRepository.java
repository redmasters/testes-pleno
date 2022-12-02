package io.red.usermanager.core.repositories;

import io.red.usermanager.core.models.Perfil;

public interface PerfilRepository {

    Perfil criarPerfil(Perfil perfil);

    void adicionarPerfil(String nomeUsuario, String nomeFuncao);
}
