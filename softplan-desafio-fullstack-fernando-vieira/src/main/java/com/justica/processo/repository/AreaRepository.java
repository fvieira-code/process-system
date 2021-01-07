package com.justica.processo.repository;

import com.justica.processo.model.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends GenericRepository<Area, String> {
    List<Area> findAll();
}
