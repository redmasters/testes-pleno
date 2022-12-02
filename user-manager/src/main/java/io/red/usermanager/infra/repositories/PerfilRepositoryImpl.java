package io.red.usermanager.infra.repositories;

import io.red.usermanager.core.models.Perfil;
import io.red.usermanager.core.repositories.PerfilRepository;
import io.red.usermanager.infra.entities.PerfilEntity;
import io.red.usermanager.infra.repositories.jpa.PerfilJpaRepository;
import io.red.usermanager.infra.repositories.jpa.UsuarioJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PerfilRepositoryImpl implements PerfilRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerfilRepositoryImpl.class);

    private final PerfilJpaRepository perfilJpaRepository;
    private final UsuarioJpaRepository usuarioJpaRepository;

    public PerfilRepositoryImpl(PerfilJpaRepository perfilJpaRepository, UsuarioJpaRepository usuarioJpaRepository) {
        this.perfilJpaRepository = perfilJpaRepository;
        this.usuarioJpaRepository = usuarioJpaRepository;
    }


    @Override
    public Perfil criarPerfil(Perfil perfil) {
        PerfilEntity novaFuncao = new Perfil(
                perfil.getNome()
        ).toEntity();
        LOGGER.info("Salvando funcao {}", perfil);
        return perfilJpaRepository.save(novaFuncao).toModel();
    }

    @Override
    public void adicionarPerfil(String nomeUsuario, String nomeFuncao) {
        final var usuario = usuarioJpaRepository.findByNomeUsuario(nomeUsuario);
        final var funcao = perfilJpaRepository.findByNome(nomeFuncao);
        usuario.ifPresent(usuarioEntity -> usuarioEntity.getPerfil().add(funcao));
    }
}
