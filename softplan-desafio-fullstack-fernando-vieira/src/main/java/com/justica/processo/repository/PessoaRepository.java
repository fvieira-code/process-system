package com.justica.processo.repository;

import com.justica.processo.model.Pessoa;
import com.justica.processo.model.domain.DominioStatusPessoa;
import com.justica.processo.model.domain.DominioTipoPessoa;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends GenericRepository<Pessoa, String> {
    boolean existsByNumeroDocumentoAndTipoPessoa(String cpfcnpj, DominioTipoPessoa tipoPessoa);
    boolean existsByNumeroDocumentoAndTipoPessoaAndStatusPessoa(String cpfcnpj, DominioTipoPessoa tipoPessoa, DominioStatusPessoa statusPessoa);
    Optional<Pessoa> findByNumeroDocumentoAndTipoPessoaAndStatusPessoa(String cpfcnpj, DominioTipoPessoa tipoPessoa, DominioStatusPessoa statusPessoa);
    Optional<Pessoa> findByNumeroDocumentoAndTipoPessoa(String cpfcnpj, DominioTipoPessoa tipoPessoa);
    List<Pessoa> findAll(Example example);
    Optional<Pessoa> findById(String id);
    List<Pessoa> findAll();
}
