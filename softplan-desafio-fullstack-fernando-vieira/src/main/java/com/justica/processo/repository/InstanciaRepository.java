package com.justica.processo.repository;

import com.justica.processo.model.Instancia;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstanciaRepository extends GenericRepository<Instancia, String> {
    List<Instancia> findAll();
}
