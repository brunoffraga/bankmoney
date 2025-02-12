package com.example.bancodinheiro.Banco.Dinheiro.domain.cliente;

public record DadosListagemCliente(Long id, String nome, String cpf) {
    
    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getCpf());
    }
}
