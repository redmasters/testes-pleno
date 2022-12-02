package io.red.usermanager.app.controllers.v1;

import io.red.usermanager.core.usecases.CriarPerfil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/usuario")
public class CriarPerfilController {

    private final CriarPerfil criar;

    public CriarPerfilController(CriarPerfil criar) {
        this.criar = criar;
    }

    @PostMapping(value = "/perfil")
    public void criarPerfil(@RequestParam(name = "nomePerfil") String nomePerfil) {
        criar.perfil(nomePerfil);
    }

}
