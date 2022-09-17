package io.red.usermanager;

import io.red.usermanager.adapters.input.UsuarioController;
import io.red.usermanager.infra.ConfigurationBeans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class, args);
    }

}
