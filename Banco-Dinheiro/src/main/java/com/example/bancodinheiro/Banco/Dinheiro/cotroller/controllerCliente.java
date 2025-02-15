package com.example.bancodinheiro.Banco.Dinheiro.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.ClienteRepository;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.DadosDetalhamentoAtualizadoCliente;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cliente.DadosListagemCliente;


/*
 * 
 * verificar o lombok pois está dando erro.
 * 
 */

@RestController
@RequestMapping("cliente")
public class controllerCliente {

    @Autowired
    private ClienteRepository repository;

/* 
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriComponentsBuilder){
        var cliente =  new Cliente(dados);
        repository.save(cliente);

        var uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoCliente(cliente));
    }
*/

    @GetMapping
    public ResponseEntity <Page<DadosListagemCliente>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemCliente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/clientesExcluidos")
    public ResponseEntity <Page<DadosListagemCliente>> listarExcluidos(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoFalse(pageable).map(DadosListagemCliente::new);
        return ResponseEntity.ok(page);
    }

/* 
    @PutMapping
    @Transactional
    public ResponseEntity Atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizacaoInformacao(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCliente(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/ativarCliente/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.ativar(id);

        return ResponseEntity.noContent().build();
    }
*/

    @GetMapping("/{id}")
    public ResponseEntity detalhaCliente(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCliente(cliente));
    }
   
}
