package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long>{
    
    Page<Conta> findAllByAtivoTrue(Pageable pageable);

    Page<Conta> findAllByAtivoFalse(Pageable pageable);

}
