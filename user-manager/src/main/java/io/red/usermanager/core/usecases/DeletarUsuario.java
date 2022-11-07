package io.red.usermanager.core.usecases;

import io.red.usermanager.core.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;

public class DeletarUsuario {
   private final UsuarioRepository usuarioRepository;

    public DeletarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<String> deletarPor(Long id, boolean ativo){
        usuarioRepository.delecaoLogicaPor(id, ativo);
        return ResponseEntity.ok().body("Deletado com sucesso");
    }
}
