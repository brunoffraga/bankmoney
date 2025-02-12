package com.example.bancodinheiro.Banco.Dinheiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.Cliente;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.RepositoryCliente;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.Conta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosCadastroConta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.RepositoryConta;

@Service
public class ContaService {

    @Autowired
    private RepositoryConta repositoryConta;

    @Autowired
    private RepositoryCliente repositoryCliente;

    public Conta criarContaComCliente(DadosCadastroConta dados){

        Cliente cliente = new Cliente(dados.cliente());
        repositoryCliente.save(cliente);

        Conta conta = new Conta(dados, cliente);
        repositoryConta.save(conta);
        
        return conta;
    }
    
}
