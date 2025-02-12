package com.example.bancodinheiro.Banco.Dinheiro.domain.fisica;

//import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.Cliente;

//import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pessoaFisica")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class PessoaFisica{

    @Id
    private String cpf;
    //@Enumerated
    //private Cliente cliente;

    public PessoaFisica(DadosCadastroPF dados){
        this.cpf = dados.cpf();
        //this.cliente = dados.cliente();
        
    }

    /*
    public PessoaFisica(String cpf){
        this.cpf = cpf;
    }
    */

    @Override
    public String toString() {
        return "cpf" + this.cpf;
    }

}
