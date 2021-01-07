package com.justica.processo.repository;

import com.justica.processo.model.Instituicao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituicaoRepository extends GenericRepository<Instituicao, String> {
    List<Instituicao> findAll();
}
