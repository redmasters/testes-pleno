package io.red.usermanager.app.controllers.v1;

import io.red.usermanager.app.controllers.v1.request.EditarUsuarioRequest;
import io.red.usermanager.app.controllers.v1.response.UsuarioResponse;
import io.red.usermanager.core.usecases.EditarUsuario;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuario")
public class EditarUsuarioController {

    private final EditarUsuario editarUsuario;

    public EditarUsuarioController(EditarUsuario editarUsuario) {
        this.editarUsuario = editarUsuario;
    }


    @PatchMapping
    public UsuarioResponse editar(@RequestBody EditarUsuarioRequest usuarioRequest){
        return editarUsuario.atualizar(usuarioRequest).toResponse();

    }
}
