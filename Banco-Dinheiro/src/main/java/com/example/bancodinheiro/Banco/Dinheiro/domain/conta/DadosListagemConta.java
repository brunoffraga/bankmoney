package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

public record DadosListagemConta(Long id, String email, String senha, double saldo, TipoConta tipoConta,
    long idCliente, String nomeCliente, String cpfCliente, int quantosCartoes) {
    
    public DadosListagemConta(Conta conta){
        this(conta.getId(), conta.getEmail(), conta.getSenha(), conta.getSaldo(), conta.getTipoconta(),
            conta.getCliente().getId(), conta.getCliente().getNome(), conta.getCliente().getCpf(), conta.getCartao().size());
    }
}
