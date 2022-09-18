package io.red.usermanager.adapters.output;

import io.red.usermanager.adapters.output.models.UsuarioModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaH2UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
