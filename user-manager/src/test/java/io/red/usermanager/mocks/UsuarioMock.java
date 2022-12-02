package io.red.usermanager.mocks;

import io.red.usermanager.app.controllers.v1.request.CriarUsuarioRequest;
import io.red.usermanager.app.controllers.v1.response.UsuarioResponse;
import io.red.usermanager.core.models.Usuario;
import io.red.usermanager.infra.entities.UsuarioEntity;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

public class UsuarioMock {

    public static CriarUsuarioRequest toRequest() {
        return new CriarUsuarioRequest(
                "Usuario",
                "user",
                "oi@oi.com",
                "123456"
        );
    }

    public static UsuarioResponse toResponse(){
        return new UsuarioResponse(
                1L,
                "Usuario",
                "user",
                "oi@oi.com",
                LocalDateTime.of(2022, Month.NOVEMBER, 10, 00, 00)

        );
    }

    public static Usuario toModel(){
        return new Usuario(
                1L,
                "Usuario",
                "user",
                "oi@oi.com",
                "123456",
                LocalDateTime.of(2022, Month.NOVEMBER, 10, 00, 00)
        );
    }

    public static Optional<UsuarioEntity> toEntity() {
        return Optional.of(new UsuarioEntity(
                1L,
                "usuario",
                "Usuario",
                "oi@oi.com",
                "123456"
        ));
    }
}
