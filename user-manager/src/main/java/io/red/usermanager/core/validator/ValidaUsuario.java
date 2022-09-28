package io.red.usermanager.core.validator;

import io.red.usermanager.core.exceptions.ValidacaoUsuarioException;
import io.red.usermanager.core.models.Usuario;

public class ValidaUsuario {
    public static void validarCriacaoUsuario(final Usuario usuario) {

        if (usuario.getSenha().length() < 6) {
            throw new ValidacaoUsuarioException("A senha deve conter mais de 6 caracteres");
        }
        if (usuario.getSenha().isBlank()) {
            throw new ValidacaoUsuarioException("Insira uma senha");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new ValidacaoUsuarioException("Necessario inserir um email");
        }

    }

    public ValidaUsuario() {
    }
}
