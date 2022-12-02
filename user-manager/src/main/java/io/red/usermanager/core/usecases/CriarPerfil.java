package io.red.usermanager.core.usecases;

import io.red.usermanager.core.models.Perfil;
import io.red.usermanager.core.repositories.PerfilRepository;

public class CriarPerfil {
    private final PerfilRepository perfilRepository;

    public CriarPerfil(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public void perfil(String nomePerfil){
        perfilRepository.criarPerfil(new Perfil(nomePerfil));
    }
}
