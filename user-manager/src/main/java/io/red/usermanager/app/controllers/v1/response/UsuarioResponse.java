package io.red.usermanager.app.controllers.v1.response;

import java.time.LocalDateTime;

public record UsuarioResponse(
        Long id,
        String nome,
        String nomeUsuario,
        String email,
        LocalDateTime dataCriacao,
        java.util.Collection<io.red.usermanager.core.models.Perfil> perfil
) {
    public record Perfil(
            Long id,
            String nome
    ) {
    }
}
