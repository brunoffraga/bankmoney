package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

public record DadosDetalhamentoCriadaConta(Long id, String email, String senha, double saldo, TipoConta tipoConta, 
String clienteNome, String clienteCpf) {

    public DadosDetalhamentoCriadaConta(Conta conta){
        this(conta.getId(), conta.getEmail(), conta.getSenha(), conta.getSaldo(), 
        conta.getTipoconta(), conta.getCliente().getNome(), conta.getCliente().getCpf());
    }
    
}
