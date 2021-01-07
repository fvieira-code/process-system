package com.justica.processo.repository;

import com.justica.processo.model.Comarca;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComarcaRepository extends GenericRepository<Comarca, String> {
    List<Comarca> findAll();
}
