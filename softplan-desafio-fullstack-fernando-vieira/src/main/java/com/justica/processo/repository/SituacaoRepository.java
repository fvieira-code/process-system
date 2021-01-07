package com.justica.processo.repository;

import com.justica.processo.model.Situacao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SituacaoRepository extends GenericRepository<Situacao, String> {
    List<Situacao> findAll();
}
