package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
    
    Page<Conta> findAllByAtivoTrue(Pageable pageable);

    Page<Conta> findAllByAtivoFalse(Pageable pageable);

    //TODO: RESOLVIDO só falta implementar ajustar o controle e serviços
    /* 
    @Query("SELECT * " + 
        "FROM cartao " + 
        "LEFT JOIN cliente ON cliente.id =  cartao.titular" + 
        "WHERE cartao.titular = clienteId")
    Page<Object[]> findCartoesByCliente(@Param("clienteId") Long cliente, Pageable pageable);
    */
}
