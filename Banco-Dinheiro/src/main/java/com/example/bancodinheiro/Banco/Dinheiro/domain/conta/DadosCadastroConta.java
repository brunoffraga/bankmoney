package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.DadosCadastroCliente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroConta(

    @NotBlank
    @Email
    String email,

    @NotBlank
    String senha,

    @NotNull
    double saldo,

    @NotNull
    TipoConta tipoconta,

    @NotNull
    @Valid
    DadosCadastroCliente cliente

) {

}
