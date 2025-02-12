package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

public record DadosDetalhamentoAtualizadoConta(Long id, String senha, double saldo, String clienteNome, String clienteCpf) {

    public DadosDetalhamentoAtualizadoConta(Conta conta){
        this(conta.getId(), conta.getSenha(), conta.getSaldo(), conta.getCliente().getNome(), 
        conta.getCliente().getCpf());
    }
    
}
