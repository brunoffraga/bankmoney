package com.example.bancodinheiro.Banco.Dinheiro.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.bancodinheiro.Banco.Dinheiro.domain.gerente.DadosAtualizacaoGerente;
import com.example.bancodinheiro.Banco.Dinheiro.domain.gerente.DadosCadastroGerente;
import com.example.bancodinheiro.Banco.Dinheiro.domain.gerente.DadosDetalhamentoAtualizadoGerente;
import com.example.bancodinheiro.Banco.Dinheiro.domain.gerente.Gerente;
import com.example.bancodinheiro.Banco.Dinheiro.domain.gerente.RepositoryGerente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("gerente")
public class controllerGerente {
    
    @Autowired
    private RepositoryGerente repository;

    @PostMapping
    @Transactional()
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroGerente dados, UriComponentsBuilder uriComponentsBuilder){
        var gerente =  new Gerente(dados);
        repository.save(gerente);

        var uri = uriComponentsBuilder.path("/conta/{id}").buildAndExpand(gerente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoGerente(gerente));
    }
/*
    @GetMapping
    public ResponseEntity<Page<DadosListagemGerente>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemGerente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemGerente>> listarExcluir(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoFalse(pageable).map(DadosListagemGerente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping
    public ResponseEntity detalhaGerente(@PathVariable Long id){
        var gerente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoGerente(gerente));
    }
 */

    @PutMapping
    @Transactional
    public ResponseEntity atulizar(@RequestBody @Valid DadosAtualizacaoGerente dados){
        var gerente = repository.getReferenceById(dados.id());
        gerente.atualizacao(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoGerente(gerente));
    }
}
