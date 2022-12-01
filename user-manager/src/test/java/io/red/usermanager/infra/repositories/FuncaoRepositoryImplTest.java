package io.red.usermanager.infra.repositories;

import io.red.usermanager.core.models.Funcao;
import io.red.usermanager.core.repositories.FuncaoRepository;
import io.red.usermanager.infra.entities.FuncaoEntity;
import io.red.usermanager.infra.repositories.jpa.FuncaoJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class FuncaoRepositoryImplTest {

    FuncaoRepository funcaoRepository;

    @MockBean
    FuncaoJpaRepository funcaoJpaRepository;

    @BeforeEach
    void setUp() {
        this.funcaoRepository = new FuncaoRepositoryImpl(funcaoJpaRepository);
    }

    @Test
    @DisplayName("Deve criar uma funcao valida")
    void deveCriarUmaFuncaoValida() {
        final var funcaoEntity = criarFuncao().toEntity();
        when(funcaoJpaRepository.save(funcaoEntity))
                .thenReturn(
                        new FuncaoEntity(
                                "funcao"
                        )
                );

        final var funcaoSalva = funcaoRepository.criarFuncao(funcaoEntity.toModel());
        Assertions.assertT
    }

    private Funcao criarFuncao() {
        return new Funcao("funcao");
    }
}
