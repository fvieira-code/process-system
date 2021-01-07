package com.justica.processo.repository;

import com.justica.processo.model.Classe;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends GenericRepository<Classe, String> {
    List<Classe> findAll();
}
