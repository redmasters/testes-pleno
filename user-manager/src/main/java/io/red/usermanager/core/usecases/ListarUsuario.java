package io.red.usermanager.core.usecases;

import io.red.usermanager.core.models.Usuario;
import io.red.usermanager.core.models.UsuarioFilter;
import io.red.usermanager.core.repositories.UsuarioRepository;

import java.util.List;

public class ListarUsuario {

    private final UsuarioRepository usuarioRepository;

    public ListarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos(){
        return usuarioRepository.listarTodos();
    }

    public Usuario usuarioPor(Long id){
        return usuarioRepository.buscarPor(id);
    }
}
