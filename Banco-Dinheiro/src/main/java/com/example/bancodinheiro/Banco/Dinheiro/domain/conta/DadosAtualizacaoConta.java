package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.DadosAtualizacaoCliente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConta(

    @NotNull
    Long id,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String senha,

    @NotNull
    Double saldo,
    
    @NotNull
    TipoConta tipoconta,

    @NotNull
    @Valid
    DadosAtualizacaoCliente cliente
    
) {

}
