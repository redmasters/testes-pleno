package io.red.usermanager.infra.config;

import io.red.usermanager.core.usecases.*;
import io.red.usermanager.infra.repositories.PerfilRepositoryImpl;
import io.red.usermanager.infra.repositories.UsuarioRepositoryImpl;
import io.red.usermanager.infra.repositories.jpa.PerfilJpaRepository;
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
    public PerfilRepositoryImpl funcaoRepository(PerfilJpaRepository perfilJpaRepository, UsuarioJpaRepository usuarioJpaRepository){
        return new PerfilRepositoryImpl(perfilJpaRepository, usuarioJpaRepository);
    }
    @Bean
    public CriarUsuario criarUsuario(UsuarioRepositoryImpl usuario) {
        return new CriarUsuario(usuario);
    }

    @Bean
    public DeletarUsuario deletarUsuario(UsuarioRepositoryImpl deletar){
        return new DeletarUsuario(deletar);
    }
    @Bean
    public EditarUsuario editarUsuario(UsuarioRepositoryImpl editar){
        return new EditarUsuario(editar);
    }

    @Bean
    public ListarUsuario listarUsuario(UsuarioRepositoryImpl listar){
        return new ListarUsuario(listar);
    }

    @Bean
    public CriarPerfil criarFuncao(PerfilRepositoryImpl criar){
        return new CriarPerfil(criar);
    }

    @Bean AdicionarPerfil adicionarFuncao(PerfilRepositoryImpl adicionar){
        return new AdicionarPerfil(adicionar);
    }


}
