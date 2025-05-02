package com.example.bancodinheiro.Banco.Dinheiro.domain.cartao;

import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.Conta;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Cartao")
@Table(name = "cartao")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double limite;
    private Boolean ativo;

    @Enumerated(EnumType.ORDINAL)
    private TipoCartao tipocartao;

    // TODO: o programa deve inserir um numeoro no cartão que deve ser aleatoreo
    private String numero;

    //
    // TODO: private Compras compras;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "titular")
    private Conta titular;

    public Cartao(DadosCadastroCartao dados){
        this.numero = dados.numero();
        this.limite = dados.limite();
        this.tipocartao = dados.tipocartao();
        this.titular = dados.conta();
        this.ativo = true;
    }

    public void atualizacao(DadosAtualizacaoCartao cartao){
        this.limite = cartao.limite();
    }

    public void ativar(Long id){
        this.ativo = true;
    }

    public void excluir(Long id){
        this.ativo = false;
    }
}
