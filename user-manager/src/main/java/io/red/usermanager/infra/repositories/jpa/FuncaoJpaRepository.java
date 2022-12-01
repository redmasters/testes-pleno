package io.red.usermanager.infra.repositories.jpa;

import io.red.usermanager.infra.entities.FuncaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncaoJpaRepository extends JpaRepository<FuncaoEntity, Long> {

    FuncaoEntity findByNome(String nome);

}
