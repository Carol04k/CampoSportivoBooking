package com.sportcenter.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sportcenter.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    
}
