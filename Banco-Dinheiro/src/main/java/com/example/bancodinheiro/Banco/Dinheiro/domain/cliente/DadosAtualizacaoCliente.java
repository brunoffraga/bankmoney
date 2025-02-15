package com.example.bancodinheiro.Banco.Dinheiro.domain.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(

    @NotNull
    Long id,

    @NotBlank
    String nome,

    @Email
    String cpf

    ) {

}
