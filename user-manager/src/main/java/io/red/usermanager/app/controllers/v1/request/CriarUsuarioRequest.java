package io.red.usermanager.app.controllers.v1.request;

import io.red.usermanager.core.models.Usuario;

public record CriarUsuarioRequest(
        String nome,
        String nomeUsuario,
        String email,
        String senha
) {
    public Usuario toModel() {
        return new Usuario(
                this.nome,
                this.nomeUsuario,
                this.email,
                this.senha
        );
    }
}
