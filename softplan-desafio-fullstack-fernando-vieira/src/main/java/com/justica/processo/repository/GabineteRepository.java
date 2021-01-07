package com.justica.processo.repository;

import com.justica.processo.model.Gabinete;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GabineteRepository extends GenericRepository<Gabinete, String> {
    List<Gabinete> findAll();
}
