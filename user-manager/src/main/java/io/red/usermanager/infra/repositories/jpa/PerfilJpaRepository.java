package io.red.usermanager.infra.repositories.jpa;

import io.red.usermanager.infra.entities.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilJpaRepository extends JpaRepository<PerfilEntity, Long> {

    PerfilEntity findByNome(String nome);

    boolean existsByNome(String nomeFuncao);
}
