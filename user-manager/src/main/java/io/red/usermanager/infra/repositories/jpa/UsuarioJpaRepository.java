package io.red.usermanager.infra.repositories.jpa;

import io.red.usermanager.infra.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findAllByNomeUsuario(String nomeUsuario);
    Optional<UsuarioEntity> existsByNomeUsuario(String nomeUsuario);
    Optional<UsuarioEntity> existsByEmail(String email);
}
