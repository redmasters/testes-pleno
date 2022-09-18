package io.red.usermanager.domain.usecases.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidacaoUsuarioException extends RuntimeException{
    public ValidacaoUsuarioException(final String message){
        super(message);
    }
}
