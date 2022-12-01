package io.red.usermanager.infra.repositories;

import io.red.usermanager.core.models.Funcao;
import io.red.usermanager.core.repositories.FuncaoRepository;
import io.red.usermanager.infra.entities.FuncaoEntity;
import io.red.usermanager.infra.repositories.jpa.FuncaoJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class FuncaoRepositoryImpl implements FuncaoRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(FuncaoRepositoryImpl.class);

    private final FuncaoJpaRepository funcaoJpaRepository;

    public FuncaoRepositoryImpl(FuncaoJpaRepository funcaoJpaRepository) {
        this.funcaoJpaRepository = funcaoJpaRepository;
    }


    @Override
    public Funcao criarFuncao(Funcao funcao) {
        FuncaoEntity novaFuncao = new Funcao(
                "usuario"
        ).toEntity();
        LOGGER.info("Salvando funcao {}", funcao);
        return funcaoJpaRepository.save(novaFuncao).toModel();
    }

    @Override
    public void adicionarFuncao(String nomeUsuario, String nomeFuncao) {

    }
}
