package com.justica.processo.repository;

import com.justica.processo.model.Vara;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaraRepository extends GenericRepository<Vara, String> {
    List<Vara> findAll();
}
