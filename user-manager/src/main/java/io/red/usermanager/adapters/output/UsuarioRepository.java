package io.red.usermanager.adapters.output;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Long, User> {
}
