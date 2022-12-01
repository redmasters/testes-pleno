package io.red.usermanager.core.models;

import io.red.usermanager.infra.entities.FuncaoEntity;

public class Funcao {
    private String nome;

    public Funcao() {
    }

    public Funcao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public FuncaoEntity toEntity() {
        return new FuncaoEntity(
                this.nome
        );

    }
}
