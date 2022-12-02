package io.red.usermanager.infra.entities;

import io.red.usermanager.core.models.Perfil;

import javax.persistence.*;

@Entity
@Table(name = "manager_perfil")
public class PerfilEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    public PerfilEntity() {
    }

    public PerfilEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public PerfilEntity(String nome) {
        this.nome = nome;
    }

    public Perfil toModel() {
        return new Perfil(
                this.nome
        );
    }
}
