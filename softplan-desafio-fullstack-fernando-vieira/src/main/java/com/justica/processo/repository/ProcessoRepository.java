package com.justica.processo.repository;

import com.justica.processo.model.Processo;
import com.justica.processo.model.domain.DominioStatusObjeto;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProcessoRepository extends GenericRepository<Processo, String> {
    boolean existsByNumeroProcesso(String numeroProcesso);
    boolean existsByNumeroProcessoAndStatusProcesso(String numeroProcesso, DominioStatusObjeto statusProcesso);
    List<Processo> findByNumeroProcesso(String numeroProcesso);
    List<Processo> findByStatusProcesso(DominioStatusObjeto statusProcesso);
    List<Processo> findByNumeroProcessoAndStatusProcesso(String numeroProcesso, DominioStatusObjeto statusProcesso);
    List<Processo> findAll();
    List<Processo> findAll(Example example);
    Optional<Processo> findByNumeroProcessoAndId(String numeroProcesso, String id);
}
