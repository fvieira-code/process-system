package com.justica.processo.converter;

import com.justica.processo.component.LogComponente;
import com.justica.processo.model.Pessoa;
import com.justica.processo.model.PessoaFisica;
import com.justica.processo.model.PessoaJuridica;
import com.justica.processo.model.Processo;
import com.justica.processo.model.dto.rest.PessoaDTO;
import com.justica.processo.model.dto.rest.ProcessoDTO;
import com.justica.processo.model.dto.rest.response.PessoaPFResponseDTO;
import com.justica.processo.model.dto.rest.response.PessoaPJResponseDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

import static com.justica.processo.constants.MensagemConstants.MSG_ENTITY_PROCESS_MENSAGEM_NOT_EMPTY;

@Log4j2
@Validated
@Component
@Getter(AccessLevel.PROTECTED)
public class ProcessoConverter {

    private final ModelMapper modelMapper;
    private final LogComponente logComponente;

    ProcessoConverter(ModelMapper modelMapper, LogComponente logComponente) {
        this.modelMapper = modelMapper;
        this.logComponente = logComponente;
    }

    public Processo converterDTOParaEntidade(@NotNull(message = MSG_ENTITY_PROCESS_MENSAGEM_NOT_EMPTY) ProcessoDTO processoDTO) {
        Processo processo = this.getModelMapper().map(processoDTO, Processo.class);
        return processo;
    }

    public ProcessoDTO converterEntidadeParaResponseDTO(@NotNull(message = MSG_ENTITY_PROCESS_MENSAGEM_NOT_EMPTY) Processo processo){
        ProcessoDTO pessoaDTO = this.getModelMapper().map(processo, ProcessoDTO.class);
        return pessoaDTO;
    }
}
