package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

import lombok.Getter;

@Getter
public enum TipoConta {

    POUPANÇA(0), CORRENTE(1), JURIDICA(2), SALARIO(3);

    private final int codigo;

    TipoConta(int codigo){
        this.codigo = codigo;
    }

    public static TipoConta fromCodigo(int codigo){
        for(TipoConta tipos : TipoConta.values()){
            if(tipos.getCodigo() == codigo){
                return tipos;
            }
        }
        throw new IllegalArgumentException("Codigo invalido" + codigo);
    }
}
