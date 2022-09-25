package io.red.usermanager.infra.repositories.jpa;

import io.red.usermanager.infra.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
}
