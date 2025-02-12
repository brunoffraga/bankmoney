package com.example.bancodinheiro.Banco.Dinheiro.domain.juridica;

//import com.example.bancodinheiro.Banco.Dinheiro.domain.Cliente.Cliente;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pessoaJuridica")
//@Entity(name = "PessoaJuridica")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cnpj")
public class PessoaJuridica{

    @Id
    private String cnpj;
    private String contato;
    //@Enumerated
    //private Cliente cliente;

    public PessoaJuridica(DadosCadastroPJ dados){
        this.cnpj = dados.cnpj();
        this.contato = dados.contato();
        //this.cliente = dados.cliente();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
