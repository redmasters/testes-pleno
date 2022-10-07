package io.red.usermanager.app.controllers.v1;

import io.red.usermanager.core.usecases.DeletarUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuario")
public class DeletarUsuarioController {

    private final DeletarUsuario deletarUsuario;

    public DeletarUsuarioController(DeletarUsuario deletarUsuario) {
        this.deletarUsuario = deletarUsuario;
    }

    @DeleteMapping
    public ResponseEntity<String> deletar(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "excluido") boolean excluido){
        return deletarUsuario.deletarPor(id, excluido);
    }
}
