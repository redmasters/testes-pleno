package io.red.usermanager.domain.usecases.validator;

import io.red.usermanager.domain.entities.Usuario;
import io.red.usermanager.domain.usecases.exceptions.ValidacaoUsuarioException;

public class ValidacaoUsuario {
    public static void validarCriacaoUsuario(final Usuario usuario){
        if(usuario.getSenha().length() < 6 ){
            throw new ValidacaoUsuarioException("A senha deve conter mais de 6 caracteres");
        }
        if(usuario.getSenha().isBlank()){
            throw new ValidacaoUsuarioException("Insira uma senha");
        }

        if(usuario.getEmail().isBlank()){
            throw new ValidacaoUsuarioException("Necessario inserir um email");
        }
    }

    public ValidacaoUsuario() {
    }
}
