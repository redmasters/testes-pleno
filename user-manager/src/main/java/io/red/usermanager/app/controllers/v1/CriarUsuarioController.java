package io.red.usermanager.app.controllers.v1;

import io.red.usermanager.app.controllers.v1.request.CriarUsuarioRequest;
import io.red.usermanager.app.controllers.v1.response.UsuarioResponse;
import io.red.usermanager.core.usecases.CriarUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuario")
public class CriarUsuarioController {

    private final CriarUsuario criarUsuario;

    public CriarUsuarioController(CriarUsuario criarUsuario) {
        this.criarUsuario = criarUsuario;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse criar(@RequestBody CriarUsuarioRequest request) {
        final var usuario = criarUsuario.criar(request.toModel());
        return usuario.toResponse();
    }
}
