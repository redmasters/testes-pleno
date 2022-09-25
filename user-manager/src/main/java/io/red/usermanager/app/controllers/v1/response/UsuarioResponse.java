package io.red.usermanager.app.controllers.v1.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UsuarioResponse(
        String nome,
        String usuario,
        LocalDateTime dataCriacao
) {
}
