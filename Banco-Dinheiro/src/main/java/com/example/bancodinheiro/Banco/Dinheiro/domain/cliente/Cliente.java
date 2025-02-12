package com.example.bancodinheiro.Banco.Dinheiro.domain.cliente;

import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.Conta;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    como fazer corretamente o relacionamento 1 para 1 entre cliente e conta, 
    onde para cada cliente tem que ter uma conta com o mesmo id, 
    com spring boot + mysql
*/

@Table(name = "cliente")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private boolean ativo = true;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Conta conta;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.ativo = true;
    }

    public void atualizacaoInformacao(DadosAtualizacaoCliente dados) {
        this.nome = dados.nome();
    }

    public void excluir(Long id) {
        this.ativo = false;
        this.conta.excluir(id);
    }

    public void ativar(Long id) {
        this.ativo = true;
        this.conta.ativar(id);
    }
    
}
