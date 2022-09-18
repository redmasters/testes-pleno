package io.red.usermanager.infra;

import io.red.usermanager.adapters.output.JpaH2UsuarioRepository;
import io.red.usermanager.adapters.output.UsuarioGateway;
import io.red.usermanager.adapters.output.impl.UsuarioDataSourceImpl;
import io.red.usermanager.adapters.repository.h2Repository.UsuarioDataSourceLocal;
import io.red.usermanager.domain.usecases.ListarUsuario;
import io.red.usermanager.domain.usecases.NovoUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    private final UsuarioDataSourceLocal dataSourceLocal = new UsuarioDataSourceImpl();


    @Bean
    public UsuarioGateway dataBase() {
        return new UsuarioGateway(usuarioDataSourceLocal);
    }

    @Bean
    public NovoUsuario novoUsuario() {
        return new NovoUsuario(dataBase());
    }

    @Bean
    public ListarUsuario listarUsuario() {
        return new ListarUsuario(database);
    }
}
