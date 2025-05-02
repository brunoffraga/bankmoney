package com.example.bancodinheiro.Banco.Dinheiro.domain.cartao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    Page<Cartao> findAllByAtivoTrue(Pageable pageable);

    Page<Cartao> findAllByAtivoFalse(Pageable pageable);

}
