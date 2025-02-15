package com.example.bancodinheiro.Banco.Dinheiro.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.ContaRepository;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosAtualizacaoConta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosCadastroConta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosDetalhamentoAtualizadoConta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosListagemConta;
import com.example.bancodinheiro.Banco.Dinheiro.service.ContaService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("conta")
public class controllerConta {
    
    @Autowired
    private ContaRepository repository;

    @Autowired
    private ContaService contaService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConta dados, UriComponentsBuilder uriComponentsBuilder){
        var conta =  contaService.criarContaComCliente(dados);

        var uri = uriComponentsBuilder.path("/conta/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoConta(conta));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemConta>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemConta::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("excluidos")
    public ResponseEntity <Page<DadosListagemConta>> listarExcluidos(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoFalse(pageable).map(DadosListagemConta::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAtualizadoConta> atualizar(@RequestBody @Valid DadosAtualizacaoConta dados){
        var conta = contaService.atualizarContaComCliente(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoConta(conta));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalheConta(@PathVariable Long id){
        var conta = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoConta(conta));
    }

    @PostMapping("ativar/{id}")
    @Transactional
    public ResponseEntity ativo(@PathVariable long id){
        var conta = repository.getReferenceById(id);
        conta.ativar(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable long id){
        var conta = repository.getReferenceById(id);
        conta.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
