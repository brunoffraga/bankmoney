package com.example.bancodinheiro.Banco.Dinheiro.domain.gerente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoGerente(

    @NotNull
    Long id,

    @NotBlank
    String nome,

    @NotBlank
    String email,

    @NotBlank
    String senha
    
) {
    
}
