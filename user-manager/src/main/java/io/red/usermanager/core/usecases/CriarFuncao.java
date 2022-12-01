package io.red.usermanager.core.usecases;

import io.red.usermanager.core.models.Funcao;
import io.red.usermanager.core.repositories.FuncaoRepository;

public class CriarFuncao {
    private final FuncaoRepository funcaoRepository;

    public CriarFuncao(FuncaoRepository funcaoRepository) {
        this.funcaoRepository = funcaoRepository;
    }

    public void criarFuncao(Funcao funcao){
        funcaoRepository.criarFuncao(funcao);
    }
}
