package io.red.usermanager.infra.repositories.jpa;

import io.red.usermanager.infra.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findAllByNomeUsuario(String nomeUsuario);
    List<UsuarioEntity> findAllByAtivo(boolean ativo);
    Optional<UsuarioEntity> findByIdAndAtivo(Long id, boolean ativo);
    Optional<UsuarioEntity> findAllByEmail(String email);
    Optional<UsuarioEntity> findByNomeUsuario(String nomeUsuario);
}
