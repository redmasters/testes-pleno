package io.red.usermanager.infra.repositories;

import io.red.usermanager.core.repositories.PerfilRepository;
import io.red.usermanager.infra.entities.PerfilEntity;
import io.red.usermanager.infra.repositories.jpa.PerfilJpaRepository;
import io.red.usermanager.infra.repositories.jpa.UsuarioJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class PerfilRepositoryImplTest {
    PerfilRepository perfilRepository;

    @MockBean
    PerfilJpaRepository perfilJpaRepository;
    @MockBean
    UsuarioJpaRepository usuarioJpaRepository;

    @BeforeEach
    void setUp() {
        this.perfilRepository = new PerfilRepositoryImpl(perfilJpaRepository, usuarioJpaRepository);
    }


    @Test
    @DisplayName("Deve criarPerfil uma funcao valida")
    void deveCriarUmaFuncaoValida() {
        final var funcaoEntity = criarFuncao();
        when(perfilJpaRepository.save(any(PerfilEntity.class)))
                .thenReturn(
                        new PerfilEntity(1L, "nome")
                );

        final var funcaoSalva = perfilRepository.criarPerfil(funcaoEntity.toModel());
        assertThat(funcaoSalva.getNome()).isNotNull();
    }


    @Test
    @DisplayName("Deve adicionar uma funcao a um usuario")
    void deveAdicionarUmaFuncaoAoUsuario() {


   }

       private PerfilEntity criarFuncao() {
        return new PerfilEntity(1L, "funcao");
    }
}
