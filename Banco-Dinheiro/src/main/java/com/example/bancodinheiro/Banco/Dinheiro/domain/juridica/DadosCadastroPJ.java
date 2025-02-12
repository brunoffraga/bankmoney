package com.example.bancodinheiro.Banco.Dinheiro.domain.juridica;

//import com.example.bancodinheiro.Banco.Dinheiro.domain.Cliente.Cliente;

//import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;

public record DadosCadastroPJ(
    
    @NotBlank
    String cnpj,
    @NotBlank
    String contato//,
    //@NotNull
    //@Valid
    //Cliente cliente

) {

}
