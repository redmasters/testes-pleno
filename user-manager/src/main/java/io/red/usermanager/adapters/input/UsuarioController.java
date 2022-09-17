package io.red.usermanager.adapters.input;

import io.red.usermanager.domain.entities.Usuario;
import io.red.usermanager.domain.usecases.ListarUsuario;
import io.red.usermanager.domain.usecases.NovoUsuario;
import org.aspectj.lang.annotation.DeclareWarning;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user-manager")
public class UsuarioController {

    private final NovoUsuario novoUsuario;
    private final ListarUsuario listarUsuario;

    public UsuarioController(NovoUsuario novoUsuario, ListarUsuario listarUsuario) {
        this.novoUsuario = novoUsuario;
        this.listarUsuario = listarUsuario;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Usuario usuario) {
        novoUsuario.criar(usuario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Usuario listar() {
        return listarUsuario.listar();
    }
}
