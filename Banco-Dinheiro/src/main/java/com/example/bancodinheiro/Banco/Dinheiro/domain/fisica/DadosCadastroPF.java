package com.example.bancodinheiro.Banco.Dinheiro.domain.fisica;

//import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.Cliente;

//import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;

public record DadosCadastroPF(

    @NotBlank
    String cpf//,
    //@NotNull
    //@Valid
    //Cliente cliente
    
) {

}
