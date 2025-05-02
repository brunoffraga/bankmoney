package com.example.bancodinheiro.Banco.Dinheiro.domain.cartao;

public record DadosDetalhamentoAtualizadoCartao(Long id, String numero, 
    TipoCartao tipocartao, Long idConta) {
    
    // TODO: Aqui tem que resolver o "cartao.getTitular().getCliente().getNome()"
    public DadosDetalhamentoAtualizadoCartao(Cartao cartao){
        this(cartao.getId(), cartao.getNumero(), cartao.getTipocartao(), 
            cartao.getTitular().getId());
    }
}
