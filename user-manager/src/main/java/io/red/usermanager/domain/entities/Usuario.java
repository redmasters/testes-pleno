package io.red.usermanager.domain.entities;

public class Usuario {
    private final Long id;
    private final String nome;
    private final String email;
    private final String senha;
    private final String nomeUsuario;

    public Usuario(Long id, String nome, String email, String senha, String nomeUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }

    public Usuario(UsuarioBuilder builder){
        this.id = builder.id;
        this.nome = builder.nome;
        this.email = builder.email;
        this.senha = builder.senha;
        this.nomeUsuario = builder.nomeUsuario;

    }
    public static class UsuarioBuilder{
        private Long id;
        private String nome;
        private String email;
        private String senha;
        private String nomeUsuario;

        public UsuarioBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UsuarioBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public UsuarioBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UsuarioBuilder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public UsuarioBuilder nomeUsuario(String nomeUsuario) {
            this.nomeUsuario = nomeUsuario;
            return this;
        }

        public Usuario build(){
            Usuario usuario = new Usuario(this);
            return usuario;
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
