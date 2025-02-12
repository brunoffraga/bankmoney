package com.example.bancodinheiro.Banco.Dinheiro.domain.cliente;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCliente(

    @NotBlank
    String nome,

    @NotBlank
    String cpf
    
    ) {

}