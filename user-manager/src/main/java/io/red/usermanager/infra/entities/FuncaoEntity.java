package io.red.usermanager.infra.entities;

import io.red.usermanager.core.models.Funcao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FuncaoEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    public FuncaoEntity() {
    }

    public FuncaoEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public FuncaoEntity(String nome) {
        this.nome = nome;
    }

    public Funcao toModel() {
        return new Funcao(
                this.nome
        );
    }
}
