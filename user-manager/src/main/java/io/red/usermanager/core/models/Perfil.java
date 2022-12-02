package io.red.usermanager.core.models;

import io.red.usermanager.infra.entities.PerfilEntity;

public class Perfil {
    private String nome;

    public Perfil() {
    }

    public Perfil(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public PerfilEntity toEntity() {
        return new PerfilEntity(
                this.nome
        );

    }
}
