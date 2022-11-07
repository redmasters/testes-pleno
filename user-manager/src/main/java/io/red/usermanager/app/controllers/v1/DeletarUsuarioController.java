package io.red.usermanager.app.controllers.v1;

import io.red.usermanager.core.usecases.DeletarUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuario")
public class DeletarUsuarioController {

    private final DeletarUsuario deletarUsuario;

    public DeletarUsuarioController(DeletarUsuario deletarUsuario) {
        this.deletarUsuario = deletarUsuario;
    }

    @PatchMapping("deletar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> exclusaoLogica(
            @RequestParam(name = "idUsuario") Long id,
            @RequestParam(name = "ativo") boolean ativo){
        return deletarUsuario.deletarPor(id, ativo);
    }
}
