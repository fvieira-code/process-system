package com.justica.processo.repository;

import com.justica.processo.model.Assunto;
import com.justica.processo.model.Classe;
import com.justica.processo.model.domain.DominioStatusObjeto;
import com.justica.processo.model.domain.DominioStatusPessoa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssuntoRepository extends GenericRepository<Assunto, String> {
    boolean existsByDescricaoAssunto(String descricaoAssunto);
    Optional<Assunto> findByDescricaoAssuntoAndStatusAssunto(String descricaoAssunto, DominioStatusObjeto statusObjeto);
    Optional<Assunto> findByCodigoUsuarioAndStatusAssunto(Integer codigoAssunto, DominioStatusObjeto statusObjeto);
    List<Assunto> findAll();
}
