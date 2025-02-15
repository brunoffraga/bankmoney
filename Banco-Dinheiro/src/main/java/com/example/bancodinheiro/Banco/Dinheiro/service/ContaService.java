package com.example.bancodinheiro.Banco.Dinheiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.Cliente;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.ClienteRepository;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.Conta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.ContaRepository;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosAtualizacaoConta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosCadastroConta;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repositoryConta;

    @Autowired
    private ClienteRepository repositoryCliente;

    public Conta criarContaComCliente(DadosCadastroConta dados){

        Cliente cliente = new Cliente(dados.cliente());

        Conta conta = new Conta(dados, cliente);
        repositoryConta.save(conta);
        
        return conta;
    }

    public Conta atualizarContaComCliente(DadosAtualizacaoConta dados) {

        var cliente = repositoryCliente.getReferenceById(dados.cliente().id());
        cliente.atualizacao(dados.cliente());
        
        var conta = repositoryConta.getReferenceById(dados.id());
        conta.atualizacao(dados, cliente);

        return conta;
    }
    
}
