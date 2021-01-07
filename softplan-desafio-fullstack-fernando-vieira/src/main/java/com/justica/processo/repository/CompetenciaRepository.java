package com.justica.processo.repository;

import com.justica.processo.model.Competencia;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends GenericRepository<Competencia, String> {
    List<Competencia> findAll();
}
