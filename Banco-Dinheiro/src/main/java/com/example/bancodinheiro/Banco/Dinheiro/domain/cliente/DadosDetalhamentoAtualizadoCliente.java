package com.example.bancodinheiro.Banco.Dinheiro.domain.cliente;

public record DadosDetalhamentoAtualizadoCliente(String nome, String cpf) {

    public DadosDetalhamentoAtualizadoCliente(Cliente cliente){
        this(cliente.getNome(), cliente.getCpf());
    }
    
}
