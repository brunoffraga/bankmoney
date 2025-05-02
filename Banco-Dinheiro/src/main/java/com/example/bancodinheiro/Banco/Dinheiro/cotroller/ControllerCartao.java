package com.example.bancodinheiro.Banco.Dinheiro.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.bancodinheiro.Banco.Dinheiro.domain.cartao.Cartao;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cartao.CartaoRepository;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cartao.DadosCadastroCartao;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cartao.DadosDetalhamentoAtualizadoCartao;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cartao.DadosListagemCartao;

import jakarta.validation.Valid;

/*
 * TODO: contruir o controller
 * TODO: arrumar o flyway_schema_history
 */

@RestController
@RequestMapping("cartao")
public class ControllerCartao {

    @Autowired
    CartaoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroCartao dados, UriComponentsBuilder uriComponentsBuilder){
        var cartao = new Cartao(dados);
        repository.save(cartao);
        
        var uri = uriComponentsBuilder.path("/cartao/{id}").buildAndExpand(cartao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoCartao(cartao));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemCartao>> lista(@PageableDefault(size = 10 , sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemCartao::new);
        return ResponseEntity.ok(page);
    }

}
