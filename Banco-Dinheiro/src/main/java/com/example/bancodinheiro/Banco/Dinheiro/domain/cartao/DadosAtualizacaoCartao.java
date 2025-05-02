package com.example.bancodinheiro.Banco.Dinheiro.domain.cartao;

import io.micrometer.common.lang.NonNull;

public record DadosAtualizacaoCartao(

    @NonNull
    Double limite

) {

}
