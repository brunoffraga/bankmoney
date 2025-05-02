package com.example.bancodinheiro.Banco.Dinheiro.domain.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Page<Cliente> findAllByAtivoTrue(Pageable pageable);

    Page<Cliente> findAllByAtivoFalse(Pageable pageable);

}
