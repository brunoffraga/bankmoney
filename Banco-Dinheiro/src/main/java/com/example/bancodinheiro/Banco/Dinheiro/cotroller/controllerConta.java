package com.example.bancodinheiro.Banco.Dinheiro.cotroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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

import com.example.bancodinheiro.Banco.Dinheiro.domain.cartao.Cartao;
import com.example.bancodinheiro.Banco.Dinheiro.domain.cartao.DadosListagemCartao;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.Conta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.ContaRepository;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosAtualizacaoConta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosCadastroConta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosDetalhamentoCriadaConta;
import com.example.bancodinheiro.Banco.Dinheiro.domain.conta.DadosListagemConta;
import com.example.bancodinheiro.Banco.Dinheiro.service.ContaService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;


@RestController
@RequestMapping("conta")
public class ControllerConta {
    
    @Autowired
    private ContaRepository repository;

    @Autowired
    private ContaService contaService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConta dados, UriComponentsBuilder uriComponentsBuilder){
        var conta =  contaService.criarContaComCliente(dados);

        var uri = uriComponentsBuilder.path("/conta/{id}").buildAndExpand(conta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCriadaConta(conta));
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
    public ResponseEntity<DadosListagemConta> atualizar(@RequestBody @Valid DadosAtualizacaoConta dados){
        var conta = contaService.atualizarContaComCliente(dados);

        return ResponseEntity.ok(new DadosListagemConta(conta));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalheConta(@PathVariable Long id){
        var conta = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemConta(conta));
    }

    @GetMapping("/cartao/{id}")
    public ResponseEntity<List<DadosListagemCartao>> listaCartao(@PathVariable Long id){
        List<Cartao> cartoes = contaService.listarTodosCartao(id);
        List<DadosListagemCartao> dadosListagemCartaos = cartoes.stream()
            .map(DadosListagemCartao::new)
            .collect(Collectors.toList());
        return ResponseEntity.ok(dadosListagemCartaos);
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity ativo(@PathVariable long id){
        Conta conta = contaService.ativarContaCliente(id);

        return ResponseEntity.ok(new DadosListagemConta(conta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> excluir(@PathVariable long id){
        try {
            boolean excluir = contaService.excluirContaCliente(id);

            if(excluir){
                return ResponseEntity.ok("Conta e cliente excluida");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encotrada");
            }
        } catch (IllegalAccessError e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(e.getMessage());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(e.getMessage());     
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Erro ao tentar excluir a conta: " + e.getMessage());
        }
    } 

}
