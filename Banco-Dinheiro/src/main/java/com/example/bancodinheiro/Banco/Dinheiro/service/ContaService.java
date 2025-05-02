package com.example.bancodinheiro.Banco.Dinheiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancodinheiro.Banco.Dinheiro.domain.cartao.Cartao;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.Cliente;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.ClienteRepository;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.Conta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.ContaRepository;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosAtualizacaoConta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosCadastroConta;

import jakarta.persistence.EntityNotFoundException;

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

    public boolean excluirContaCliente(Long id){

        try {
            var conta = repositoryConta.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada"));

            if(conta.getSaldo() > 0){
                throw new IllegalArgumentException("Não é possível excluir a conta com saldo maior que 0.");
            }

            var cliente = repositoryCliente.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrada"));

            conta.excluir(id);
            cliente.excluir(id);
            return true;
            
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Conta ou Cliente não encontrada, não foi possível excluir.");   
        } catch (IllegalAccessError e) {
            throw e;
        }catch (Exception e) {
            throw new RuntimeException("Erro inesperado ao tentar excluir: " + e.getMessage());
        }

    }

    public Conta ativarContaCliente(Long id){
        
        var conta = repositoryConta.getReferenceById(id);
        conta.ativar(id);

        var cliente = repositoryCliente.getReferenceById(id);
        cliente.ativar(id);

        return conta;
    }

    public List<Cartao> listarTodosCartao(Long id){
        Conta conta = repositoryConta.findById(id)
        .orElseThrow(() -> new RuntimeException("Conta não encontrada com o id: " + id));

        List<Cartao> cartoes = conta.getCartao();  // Obtemos a lista de cartões

        // Adicionando log para verificar a lista de cartões
        if (cartoes.isEmpty()) {
            System.out.println("Conta com id " + id + " não possui cartões associados.");
        } else {
            System.out.println("Cartões encontrados para a conta com id " + id + ": " + cartoes.size());
        }

        return cartoes;
    }

}
