package io.red.usermanager.infra.config;

import io.red.usermanager.core.usecases.CriarUsuario;
import io.red.usermanager.core.usecases.ListarUsuario;
import io.red.usermanager.infra.repositories.UsuarioRepositoryImpl;
import io.red.usermanager.infra.repositories.jpa.UsuarioJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UsuarioRepositoryImpl usuarioRepository(UsuarioJpaRepository usuarioRepository){
        return new UsuarioRepositoryImpl(usuarioRepository);
    }
    @Bean
    public CriarUsuario criarUsuario(UsuarioRepositoryImpl usuario) {
        return new CriarUsuario(usuario);
    }

    @Bean
    public ListarUsuario listarUsuario(UsuarioRepositoryImpl listar){
        return new ListarUsuario(listar);
    }


}
