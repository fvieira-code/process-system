package com.justica.processo.repository;

import com.justica.processo.model.ControleMensagem;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleMensagemRepository extends GenericRepository<ControleMensagem, String> {
}
