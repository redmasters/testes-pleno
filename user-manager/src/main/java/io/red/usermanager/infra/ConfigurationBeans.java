package io.red.usermanager.infra;

import io.red.usermanager.adapters.output.UsuarioGateway;
import io.red.usermanager.domain.usecases.ListarUsuario;
import io.red.usermanager.domain.usecases.NovoUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {
    private final UsuarioGateway database = new UsuarioGateway();


    @Bean
    public NovoUsuario novoUsuario() {
        return new NovoUsuario(database);
    }

    @Bean
    public ListarUsuario listarUsuario() {
        return new ListarUsuario(database);
    }
}
