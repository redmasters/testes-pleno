package io.red.usermanager.app.controllers.v1.response;

import java.time.LocalDateTime;

public record UsuarioResponse(
        Long id,
        String nome,
        String nomeUsuario,
        String email,
        LocalDateTime dataCriacao
) {
}
