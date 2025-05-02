package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

import java.util.List;

import com.example.bancodinheiro.Banco.Dinheiro.domain.cartao.Cartao;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String senha;
    private double saldo;
    private boolean ativo = true;

    @Enumerated(EnumType.ORDINAL)
    private TipoConta tipoconta;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id") 
    private Cliente cliente;

    /*
     * TODO: fazer um get de lista de cartao.
     * não pode ter referencia cruzada, pois pode ter inconcistencia no banco.
     * Então quando tiver um onetomany coloca a referencia só em um local no lado do many
     */
    @OneToMany
    @JoinColumn(name = "id")
    private List<Cartao> cartao;

    public Conta(DadosCadastroConta dados, Cliente cliente) {
        this.email = dados.email();
        this.senha = dados.senha();
        this.saldo = Math.max(dados.saldo(), 0);
        this.tipoconta = dados.tipoconta();
        this.cliente = cliente;
        this.ativo = true;
    }

    public void atualizacao(DadosAtualizacaoConta dados, Cliente cliente) {
        this.email = dados.email();
        this.senha = dados.senha();
        this.saldo = Math.max(dados.saldo(), 0);
        this.tipoconta = dados.tipoconta();
        this.cliente = cliente;
    }

    public void excluir(Long id) {
        this.ativo = false;
    }

    public void ativar(Long id) {
        this.ativo = true;
    }
    
}
