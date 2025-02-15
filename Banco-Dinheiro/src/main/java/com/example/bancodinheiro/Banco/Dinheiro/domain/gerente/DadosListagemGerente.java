package com.example.bancodinheiro.Banco.Dinheiro.domain.gerente;

public record DadosListagemGerente(Long id, String nome, String email, String senha) {

    public DadosListagemGerente(Gerente gerente){
        this(gerente.getId(), gerente.getNome(), gerente.getEmail(), gerente.getSenha());
    }

}
