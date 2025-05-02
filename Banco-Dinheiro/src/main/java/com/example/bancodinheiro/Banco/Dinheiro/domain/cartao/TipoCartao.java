package com.example.bancodinheiro.Banco.Dinheiro.domain.cartao;

import lombok.Getter;

@Getter
public enum TipoCartao {

    CREDITO(0), DEBITO(1);

    private final int codigo;

    TipoCartao(int codigo) {
        this.codigo = codigo;
    }
    
    public static TipoCartao fromTipoCartao(int codigo){
        for(TipoCartao tipos : TipoCartao.values()){
            if(tipos.getCodigo() == codigo){
                return tipos;
            }
        }
        throw new IllegalArgumentException("Codigo invalido" + codigo);
    }
    
}
