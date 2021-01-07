package com.justica.processo.service;

import com.justica.processo.model.ControleMensagem;
import com.justica.processo.repository.ControleMensagemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Log4j2
@Service
@Validated
public class ControleMensagemService extends GenericService<ControleMensagemRepository, ControleMensagem, String> {
    @Autowired
    public ControleMensagemService(ControleMensagemRepository repository) {
        super(repository);
    }
}
