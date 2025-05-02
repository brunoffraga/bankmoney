package com.example.bancodinheiro.Banco.Dinheiro.domain.cartao;

public record DadosListagemCartao(Long id, String numero, double limite, TipoCartao tipoCartao, 
    Long idcatao, String nome) {

        public DadosListagemCartao(Cartao cartao){
            this(cartao.getId(), cartao.getNumero(), cartao.getLimite(), cartao.getTipocartao(), 
            cartao.getTitular().getId(), cartao.getTitular().getCliente().getNome());
        }
    
}
