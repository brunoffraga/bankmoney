package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "conta")
@Entity(name = "Conta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id
    private long id;

    private String email;
    private String senha;
    private double saldo;
    private boolean ativo = true;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "id") 
    private Cliente cliente;

    public Conta(DadosCadastroConta dados, Cliente cliente) {
        this.email = dados.email();
        this.senha = dados.senha();
        this.saldo = Math.max(dados.saldo(), 0);
        this.ativo = true;
        this.cliente = cliente;
    }

    public void atualizacao(DadosAtualizacaoConta dados, Cliente cliente) {
        this.email = dados.email();
        this.senha = dados.senha();
        this.cliente = cliente;
    }

    public void excluir(Long id) {
        this.ativo = false;
    }

    public void ativar(Long id) {
        this.ativo = true;
    }
    
}
