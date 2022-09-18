package io.red.usermanager.adapters.input;

import io.red.usermanager.domain.entities.Usuario;
import io.red.usermanager.domain.usecases.ListarUsuario;
import io.red.usermanager.domain.usecases.NovoUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criar(@RequestBody Usuario usuario) {
        novoUsuario.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado com sucesso");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Usuario listar() {
        return listarUsuario.listar();
    }
}
