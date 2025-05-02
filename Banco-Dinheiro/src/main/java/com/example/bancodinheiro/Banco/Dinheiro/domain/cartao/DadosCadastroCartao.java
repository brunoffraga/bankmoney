package com.example.bancodinheiro.Banco.Dinheiro.domain.cartao;

import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.Conta;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;

public record  DadosCadastroCartao(

    @NotBlank
    String numero,

    @NonNull
    Double limite,

    @NonNull
    TipoCartao tipocartao,

    @NonNull
    Conta conta

) {

}
