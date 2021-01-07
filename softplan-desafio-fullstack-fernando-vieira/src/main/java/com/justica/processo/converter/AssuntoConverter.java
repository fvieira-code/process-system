package com.justica.processo.converter;

import com.justica.processo.component.LogComponente;
import com.justica.processo.model.Assunto;
import com.justica.processo.model.dto.rest.request.AssuntoRequestDTO;
import com.justica.processo.model.dto.rest.response.AssuntoResponseDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

import static com.justica.processo.constants.MensagemConstants.MSG_ENTITY_ASSUNTO_MENSAGEM_NOT_EMPTY;

@Log4j2
@Validated
@Component
@Getter(AccessLevel.PROTECTED)
public class AssuntoConverter {

    private final ModelMapper modelMapper;
    private final LogComponente logComponente;

    AssuntoConverter(ModelMapper modelMapper, LogComponente logComponente) {
        this.modelMapper = modelMapper;
        this.logComponente = logComponente;
    }

    public Assunto converterDTOParaEntidade(@NotNull(message = MSG_ENTITY_ASSUNTO_MENSAGEM_NOT_EMPTY) AssuntoRequestDTO assuntoRequestDTO) {
        Assunto assunto = this.getModelMapper().map(assuntoRequestDTO, Assunto.class);
        return assunto;
    }

    public AssuntoResponseDTO converterEntidadeParaResponseDTO(@NotNull(message = MSG_ENTITY_ASSUNTO_MENSAGEM_NOT_EMPTY) Assunto assunto){
        AssuntoResponseDTO assuntoResponseDTO = this.getModelMapper().map(assunto, AssuntoResponseDTO.class);
        return assuntoResponseDTO;
    }
}
