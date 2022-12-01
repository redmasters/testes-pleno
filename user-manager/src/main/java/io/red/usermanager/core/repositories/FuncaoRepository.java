package io.red.usermanager.core.repositories;

import io.red.usermanager.core.models.Funcao;

public interface FuncaoRepository {

    Funcao criarFuncao(Funcao funcao);

    void adicionarFuncao(String nomeUsuario, String nomeFuncao);
}
