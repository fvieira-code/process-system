package com.justica.processo.service;

import com.justica.processo.converter.AssuntoConverter;
import com.justica.processo.exception.ObjetoDuplicadoException;
import com.justica.processo.exception.ObjetoNaoEncontradoException;
import com.justica.processo.model.Assunto;
import com.justica.processo.model.domain.DominioStatusObjeto;
import com.justica.processo.model.dto.rest.request.AssuntoRequestDTO;
import com.justica.processo.model.dto.rest.response.AssuntoResponseDTO;
import com.justica.processo.repository.AssuntoRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

import static com.justica.processo.constants.MensagemConstants.MSG_SERVICE_ASSUNTO_NOT_EMPTY;

@Log4j2
@Service
@Validated
public class AssuntoService extends GenericService<AssuntoRepository, Assunto, String> {
    private final ModelMapper modelMapper;
    private final AssuntoConverter assuntoConverter;

    @Autowired
    public AssuntoService(AssuntoRepository repository, ModelMapper modelMapper, AssuntoConverter assuntoConverter) {
        super(repository);
        this.modelMapper = modelMapper;
        this.assuntoConverter = assuntoConverter;
    }

    public AssuntoResponseDTO consultarAssunto(@NotNull(message = MSG_SERVICE_ASSUNTO_NOT_EMPTY)AssuntoRequestDTO assuntoRequestDTO) {
        log.info("Iniciando consulta do assunto [{}]...", assuntoRequestDTO.getDescricaoAssunto());
            Optional<Assunto> optionalAssunto = this.repository.findByDescricaoAssuntoAndStatusAssunto(
                    assuntoRequestDTO.getDescricaoAssunto(), DominioStatusObjeto.ATIVO);

        log.info("Finalizando consulta do assunto [{}]...", assuntoRequestDTO.getDescricaoAssunto());

        return this.assuntoConverter.converterEntidadeParaResponseDTO(optionalAssunto.get());
    }

    @Transactional
    public AssuntoResponseDTO incluirAssunto(@NotNull(message = MSG_SERVICE_ASSUNTO_NOT_EMPTY) AssuntoRequestDTO assuntoRequestDTO){

        log.info("Iniciando inclusão do assunto [{}]...", assuntoRequestDTO.getDescricaoAssunto());

        if (this.existeAssunto(assuntoRequestDTO.getDescricaoAssunto())) {
            throw new ObjetoDuplicadoException(assuntoRequestDTO.getDescricaoAssunto());
        }

        log.info("Assunto [{}] incluído", assuntoRequestDTO.getDescricaoAssunto());
        return salvarAssunto(assuntoRequestDTO);
    }

    @Transactional
    public AssuntoResponseDTO alterarAssunto(@NotNull(message =MSG_SERVICE_ASSUNTO_NOT_EMPTY)
                                                         AssuntoRequestDTO assuntoRequestDTO, DominioStatusObjeto dominioStatusObjeto) {
        log.info("Iniciando alteração do assunto [{}]...", assuntoRequestDTO.getDescricaoAssunto());

        if (this.existeAssunto(assuntoRequestDTO.getDescricaoAssunto())) {

            Assunto assunto =  this.repository.findByDescricaoAssuntoAndStatusAssunto(assuntoRequestDTO.getDescricaoAssunto(), dominioStatusObjeto).orElseThrow(() ->
                    new ObjetoNaoEncontradoException("service.objeto.notnull.message", assuntoRequestDTO.getDescricaoAssunto()));

            super.repository.save(assunto);

        } else {
            throw new ObjetoNaoEncontradoException("service.pessoa.notnull.message", assuntoRequestDTO.getDescricaoAssunto());
        }

        return salvarAssunto(assuntoRequestDTO);
    }

    @Transactional
    public AssuntoResponseDTO excluirAssunto(@NotNull(message = MSG_SERVICE_ASSUNTO_NOT_EMPTY)  AssuntoRequestDTO assuntoRequestDTO, DominioStatusObjeto dominioStatusObjeto){
        log.info("Iniciando exclusão da pessoa [{}]...", assuntoRequestDTO.getDescricaoAssunto());

        Assunto assunto =  this.repository.findByDescricaoAssuntoAndStatusAssunto(assuntoRequestDTO.getDescricaoAssunto(), DominioStatusObjeto.ATIVO).orElseThrow(() ->
                new ObjetoNaoEncontradoException("service.objeto.notnull.message", assuntoRequestDTO.getDescricaoAssunto()));

        log.info("Assunto [{}] excluído", assuntoRequestDTO.getDescricaoAssunto());
        return this.atualizaSituacaoAssunto(assunto, dominioStatusObjeto);
    }

    private AssuntoResponseDTO salvarAssunto(@NotNull(message = "service.objeto.notnull.message") AssuntoRequestDTO assuntoRequestDTO) {
            Assunto assunto = this.assuntoConverter.converterDTOParaEntidade(assuntoRequestDTO);
            return this.assuntoConverter.converterEntidadeParaResponseDTO(super.repository.save(assunto));
    }

    private AssuntoResponseDTO atualizaSituacaoAssunto(Assunto assunto, DominioStatusObjeto dominioStatusObjeto ) {
        log.info("Atualizando do status do assunto [{}] para [{}]", assunto.getDescricaoAssunto(), dominioStatusObjeto);
        assunto.setStatusAssunto(dominioStatusObjeto);
        log.debug("Atualização do status do assunto realizado com sucesso...");
        return this.assuntoConverter.converterEntidadeParaResponseDTO(super.repository.save(assunto));
    }

    public boolean existeAssunto(@NotEmpty(message = MSG_SERVICE_ASSUNTO_NOT_EMPTY) String descricaoAssunto) {
        return super.repository.existsByDescricaoAssunto(descricaoAssunto);
    }
}
