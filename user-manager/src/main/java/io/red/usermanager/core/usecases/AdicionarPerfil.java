package io.red.usermanager.core.usecases;

import io.red.usermanager.core.repositories.PerfilRepository;

public class AdicionarPerfil {
    private final PerfilRepository perfilRepository;

    public AdicionarPerfil(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public void perfil(String nomeUsuario, String nomePerfil){
        perfilRepository.adicionarPerfil(nomeUsuario, nomePerfil);
    }
}
