package com.justica.processo.repository;

import com.justica.processo.model.Secretaria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecretariaRepository extends GenericRepository<Secretaria, String> {
    List<Secretaria> findAll();
}
