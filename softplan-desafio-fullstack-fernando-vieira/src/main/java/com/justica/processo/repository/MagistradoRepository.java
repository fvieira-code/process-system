package com.justica.processo.repository;

import com.justica.processo.model.Magistrado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagistradoRepository extends GenericRepository<Magistrado, String> {
    List<Magistrado> findAll();
}
