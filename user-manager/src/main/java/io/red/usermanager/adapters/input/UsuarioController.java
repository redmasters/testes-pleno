package io.red.usermanager.adapters.input;

import io.red.usermanager.domain.entities.Usuario;
import io.red.usermanager.domain.usecases.NovoUsuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user-manager")
public class UsuarioController {

    private final NovoUsuario novoUsuario;

    public UsuarioController(NovoUsuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return novoUsuario.criar(usuario);

    }
}
