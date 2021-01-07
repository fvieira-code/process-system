package com.justica.processo.converter;

import com.justica.processo.component.LogComponente;
import com.justica.processo.model.Pessoa;
import com.justica.processo.model.PessoaFisica;
import com.justica.processo.model.PessoaJuridica;
import com.justica.processo.model.dto.rest.PessoaDTO;
import com.justica.processo.model.dto.rest.response.PessoaPFResponseDTO;
import com.justica.processo.model.dto.rest.response.PessoaPJResponseDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

import static com.justica.processo.constants.MensagemConstants.MSG_ENTITY_PESSOA_MENSAGEM_NOT_EMPTY;

@Log4j2
@Validated
@Component
@Getter(AccessLevel.PROTECTED)
public class PessoaConverter {

    private final ModelMapper modelMapper;
    private final LogComponente logComponente;

    PessoaConverter(ModelMapper modelMapper, LogComponente logComponente) {
        this.modelMapper = modelMapper;
        this.logComponente = logComponente;
    }

    public PessoaFisica converterDTOParaPFEntidade(@NotNull(message = MSG_ENTITY_PESSOA_MENSAGEM_NOT_EMPTY) PessoaDTO pessoaDTO) {
        PessoaFisica pessoaFisica = this.getModelMapper().map(pessoaDTO, PessoaFisica.class);
        return pessoaFisica;
    }

    public PessoaJuridica converterDTOParaPJEntidade(@NotNull(message = MSG_ENTITY_PESSOA_MENSAGEM_NOT_EMPTY) PessoaDTO pessoaDTO) {
        PessoaJuridica pessoaJuridica = this.getModelMapper().map(pessoaDTO, PessoaJuridica.class);
        return pessoaJuridica;
    }
    public PessoaDTO converterEntidadeParaResponseDTO(@NotNull(message = MSG_ENTITY_PESSOA_MENSAGEM_NOT_EMPTY) Pessoa pessoa){
        PessoaDTO pessoaDTO = this.getModelMapper().map(pessoa, PessoaDTO.class);
        return pessoaDTO;
    }

    public PessoaPFResponseDTO converterEntidadeParaPFResponseDTO(@NotNull(message = MSG_ENTITY_PESSOA_MENSAGEM_NOT_EMPTY) PessoaFisica pessoaFisica){
        PessoaPFResponseDTO pessoaPFResponseDTO = this.getModelMapper().map(pessoaFisica, PessoaPFResponseDTO.class);
        return pessoaPFResponseDTO;
    }

    public PessoaPJResponseDTO converterEntidadeParaPJResponseDTO(@NotNull(message = MSG_ENTITY_PESSOA_MENSAGEM_NOT_EMPTY) PessoaJuridica pessoaJuridica){
        PessoaPJResponseDTO pessoaPJResponseDTO = this.getModelMapper().map(pessoaJuridica, PessoaPJResponseDTO.class);
        return pessoaPJResponseDTO;
    }
}
