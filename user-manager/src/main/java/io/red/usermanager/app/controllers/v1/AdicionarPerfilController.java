package io.red.usermanager.app.controllers.v1;

import io.red.usermanager.core.usecases.AdicionarPerfil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuario")
public class AdicionarPerfilController {

    private final AdicionarPerfil adicionarPerfil;

    public AdicionarPerfilController(AdicionarPerfil adicionarPerfil) {
        this.adicionarPerfil = adicionarPerfil;
    }

    @PatchMapping(value = "/perfil")
    public void adicionarPerfil(
            @RequestParam(name = "nomeUsuario") String nomeUsuario,
            @RequestParam(name = "nomePerfil") String nomePerfil){
        adicionarPerfil.perfil(nomeUsuario, nomePerfil);
    }
}
