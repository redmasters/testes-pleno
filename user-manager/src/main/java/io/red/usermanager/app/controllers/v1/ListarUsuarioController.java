package io.red.usermanager.app.controllers.v1;

import io.red.usermanager.app.controllers.v1.response.UsuarioResponse;
import io.red.usermanager.core.usecases.ListarUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/usuario")
public class ListarUsuarioController {

    private final ListarUsuario listarUsuario;

    public ListarUsuarioController(ListarUsuario listarUsuario) {
        this.listarUsuario = listarUsuario;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioResponse> listarTodos(){
       final var usuarios=listarUsuario.listarTodos();
       List<UsuarioResponse> usuarioResponseList = new ArrayList<>();
       usuarios.forEach(usuario -> {
           usuarioResponseList.add(usuario.toResponse());
       });
       return usuarioResponseList;
    }

}


