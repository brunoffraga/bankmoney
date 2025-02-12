package com.example.bancodinheiro.Banco.Dinheiro.domain.conta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryConta extends JpaRepository<Conta, Long>{
    
    Page<Conta> findAllByAtivoTrue(Pageable pageable);

    Page<Conta> findAllByAtivoFalse(Pageable pageable);

}
