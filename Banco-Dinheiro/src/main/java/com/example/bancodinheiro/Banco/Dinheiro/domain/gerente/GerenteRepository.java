package com.example.bancodinheiro.Banco.Dinheiro.domain.gerente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {
    
    Page<Gerente> findAllByAtivoTrue(Pageable pageable);
    
    Page<Gerente> findAllByAtivoFalse(Pageable pageable);

}
