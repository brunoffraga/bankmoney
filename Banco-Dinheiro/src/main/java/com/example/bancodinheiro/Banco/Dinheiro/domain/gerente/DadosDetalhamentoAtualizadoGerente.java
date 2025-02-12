package com.example.bancodinheiro.Banco.Dinheiro.domain.gerente;

public record DadosDetalhamentoAtualizadoGerente(Long id, String nome, String email, String senha) {
    
    public DadosDetalhamentoAtualizadoGerente(Gerente gerente) {
        this(gerente.getId(), gerente.getNome(), gerente.getEmail(), gerente.getSenha());
    }

}
