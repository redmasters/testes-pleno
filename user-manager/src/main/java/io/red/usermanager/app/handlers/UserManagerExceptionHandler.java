package io.red.usermanager.app.handlers;

import io.red.usermanager.core.exceptions.UsuarioException;
import io.red.usermanager.core.exceptions.ValidacaoUsuarioException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class UserManagerExceptionHandler extends ResponseEntityExceptionHandler {
    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se " + "o problema persistir, entre em contato com o administrador do sistema.";

    @ExceptionHandler(value = ValidacaoUsuarioException.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ProblemType problemType = ProblemType.DADOS_INVALIDOS;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(status, problemType, detail).userMessage(detail).build();
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(value = UsuarioException.class)
    protected ResponseEntity<Object> usuarioEx(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ProblemType problemType = ProblemType.RECURSO_NAO_ENCONTRADO;
        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(status, problemType, detail).userMessage(detail).build();
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }



    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (body == null) {
            body = Problem.builder().timestamp(OffsetDateTime.now()).title(status.getReasonPhrase()).status(status.value()).userMessage(MSG_ERRO_GENERICA_USUARIO_FINAL).build();
        } else if (body instanceof String) {
            body = Problem.builder().timestamp(OffsetDateTime.now()).title((String) body).status(status.value()).userMessage(MSG_ERRO_GENERICA_USUARIO_FINAL).build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, ProblemType problemType, String detail) {

        return Problem.builder().timestamp(OffsetDateTime.now()).status(status.value()).type(problemType.getUri()).title(problemType.getTitle()).detail(detail);
    }
}
