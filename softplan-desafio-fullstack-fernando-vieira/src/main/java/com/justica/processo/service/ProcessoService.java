package com.justica.processo.service;

import com.justica.processo.converter.ProcessoConverter;
import com.justica.processo.exception.ObjetoDuplicadoException;
import com.justica.processo.exception.ObjetoNaoEncontradoException;
import com.justica.processo.exception.RegraNegocioException;
import com.justica.processo.model.*;
import com.justica.processo.model.domain.DominioStatusObjeto;
import com.justica.processo.model.dto.rest.ProcessoDTO;
import com.justica.processo.repository.*;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.justica.processo.constants.MensagemConstants.MSG_SERVICE_PROCESSO_NOT_EMPTY;
import static com.justica.processo.constants.MensagemConstants.MSG_DTO_PROCESSO_STATUS_PROCESSO_NOT_NULL;

@Log4j2
@Service
@Validated
public class ProcessoService extends GenericService<ProcessoRepository, Processo, String> {
    private final ModelMapper modelMapper;
    private final ProcessoConverter processoConverter;
    private final InstanciaRepository instanciaRepository;
    private final AreaRepository areaRepository;
    private final ComarcaRepository comarcaRepository;
    private final SituacaoRepository situacaoRepository;
    private final VaraRepository varaRepository;
    private final GabineteRepository gabineteRepository;
    private final SecretariaRepository secretariaRepository;
    private final MagistradoRepository magistradoRepository;
    private final CompetenciaRepository competenciaRepository;
    private final ClasseRepository classeRepository;
    private final AssuntoRepository assuntoRepository;
    private final InstituicaoRepository instituicaoRepository;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public ProcessoService(ProcessoRepository repository, ModelMapper modelMapper, ProcessoConverter processoConverter,
                           InstanciaRepository instanciaRepository, AreaRepository areaRepository,
                           SituacaoRepository situacaoRepository, ComarcaRepository comarcaRepository,
                           VaraRepository varaRepository, GabineteRepository gabineteRepository,
                           SecretariaRepository secretariaRepository, MagistradoRepository magistradoRepository,
                           CompetenciaRepository competenciaRepository, ClasseRepository classeRepository,
                           AssuntoRepository assuntoRepository, InstituicaoRepository instituicaoRepository,
                           PessoaRepository pessoaRepository ) {
        super(repository);
        this.modelMapper = modelMapper;
        this.processoConverter = processoConverter;
        this.situacaoRepository = situacaoRepository;
        this.instanciaRepository = instanciaRepository;
        this.areaRepository = areaRepository;
        this.comarcaRepository = comarcaRepository;
        this.varaRepository = varaRepository;
        this.gabineteRepository = gabineteRepository;
        this.secretariaRepository = secretariaRepository;
        this.magistradoRepository = magistradoRepository;
        this.competenciaRepository = competenciaRepository;
        this.classeRepository = classeRepository;
        this.assuntoRepository = assuntoRepository;
        this.instituicaoRepository = instituicaoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public List<Instancia> obterListaInstancia() {
        return this.instanciaRepository.findAll();
    }

    @Transactional
    public List<Area> obterListaArea() {
        return this.areaRepository.findAll();
    }

    @Transactional
    public List<Comarca> obterListaComarca() {
        return this.comarcaRepository.findAll();
    }

    @Transactional
    public List<Situacao> obterListaSituacao() { return this.situacaoRepository.findAll(); }

    @Transactional
    public List<Vara> obterListaVara() {
        return this.varaRepository.findAll();
    }

    @Transactional
    public List<Gabinete> obterListaGabinete() {
        return this.gabineteRepository.findAll();
    }

    @Transactional
    public List<Secretaria> obterListaSecretaria() {
        return this.secretariaRepository.findAll();
    }

    @Transactional
    public List<Magistrado> obterListaMagistrado() {
        return this.magistradoRepository.findAll(); }

    @Transactional
    public List<Competencia> obterListaCompetencia() {
        return this.competenciaRepository.findAll();
    }

    @Transactional
    public List<Classe> obterListaClasse() {
        return this.classeRepository.findAll();
    }

    @Transactional
    public List<Assunto> obterListaAssunto() {
        return this.assuntoRepository.findAll();
    }

    @Transactional
    public List<Instituicao> obterListaInstituicao() {
        return this.instituicaoRepository.findAll(); }

    @Transactional
    public List<Processo> consultarProcesso(@NotNull(message = MSG_SERVICE_PROCESSO_NOT_EMPTY) Processo processoFiltro) {
        Example example = Example.of( processoFiltro,
                ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) );
        log.info("Finalizando consulta do processo [{}]...", processoFiltro.getNumeroProcesso());
        return this.repository.findAll(example);
    }

    @Transactional
    public List<Processo> obterListaProcesso() { return this.repository.findAll(); }

    @Transactional
    public List<Processo> obterProcessoPorNumero(@NotNull(message = MSG_SERVICE_PROCESSO_NOT_EMPTY) String numeroProcesso) {
        log.info("Finalizando consulta do processo [{}]...", numeroProcesso);
        return this.repository.findByNumeroProcesso(numeroProcesso);
    }

    @Transactional
    public List<Processo> obterProcessoPorStatus(@NotNull(message = MSG_DTO_PROCESSO_STATUS_PROCESSO_NOT_NULL) DominioStatusObjeto statusProcesso) {
        log.info("Finalizando consulta do processo [{}]...", statusProcesso);
        return this.repository.findByStatusProcesso(statusProcesso);
    }

    @Transactional
    public List<Processo> obterProcessoPorNumeroPorStatus(@NotNull(message = MSG_SERVICE_PROCESSO_NOT_EMPTY) String numeroProcesso,
                                                          @NotNull(message = MSG_DTO_PROCESSO_STATUS_PROCESSO_NOT_NULL) DominioStatusObjeto statusProcesso) {
        log.info("Finalizando consulta do processo [{}]...", numeroProcesso);
        return this.repository.findByNumeroProcessoAndStatusProcesso(numeroProcesso, statusProcesso);
    }

    @Transactional
    public ProcessoDTO incluirProcesso(@NotNull(message = MSG_SERVICE_PROCESSO_NOT_EMPTY) ProcessoDTO processoDTO){

        log.info("Iniciando inclusão do processo [{}]...", processoDTO.getNumeroProcesso());

        if (this.existeProcesso(processoDTO.getNumeroProcesso())) {
            throw new ObjetoDuplicadoException(processoDTO.getNumeroProcesso());
        }

        log.info("Processo [{}] incluído", processoDTO.getNumeroProcesso());

        return salvarProcesso(processoDTO);
    }

    @Transactional
    public ProcessoDTO alterarProcesso(@NotNull(message = MSG_SERVICE_PROCESSO_NOT_EMPTY) ProcessoDTO processoDTO,
                                       DominioStatusObjeto statusProcesso) {
        log.info("Iniciando alteração do processo [{}]...", processoDTO.getNumeroProcesso());

        if (this.existeProcesso(processoDTO.getNumeroProcesso())) {
            Processo processo = this.repository.findByNumeroProcessoAndId(
                    processoDTO.getNumeroProcesso(), processoDTO.getId().toString())
                    .orElseThrow(() ->
                            new ObjetoNaoEncontradoException(MSG_SERVICE_PROCESSO_NOT_EMPTY, processoDTO.getNumeroProcesso()));

            processo.setStatusProcesso(statusProcesso);
            processo.setId(processoDTO.getId().toString());
            super.repository.save(processo);

        } else {
            throw new ObjetoNaoEncontradoException(MSG_SERVICE_PROCESSO_NOT_EMPTY, processoDTO.getNumeroProcesso());
        }

        return salvarProcesso(processoDTO);
    }

    @Transactional
    public ProcessoDTO excluirProcesso(@NotNull(message = MSG_SERVICE_PROCESSO_NOT_EMPTY)  ProcessoDTO processoDTO,
                                       DominioStatusObjeto statusProcesso){
        log.info("Iniciando exclusão do processo [{}]...", processoDTO.getNumeroProcesso());
        if (this.existeProcesso(processoDTO.getNumeroProcesso())) {
            Processo processo = this.repository.findByNumeroProcessoAndId(
                    processoDTO.getNumeroProcesso(), processoDTO.getId().toString())
                    .orElseThrow(() ->
                            new ObjetoNaoEncontradoException(MSG_SERVICE_PROCESSO_NOT_EMPTY, processoDTO.getNumeroProcesso()));

            processo.setStatusProcesso(statusProcesso);
            super.repository.save(processo);

        } else {
            throw new ObjetoNaoEncontradoException(MSG_SERVICE_PROCESSO_NOT_EMPTY, processoDTO.getNumeroProcesso());
        }

        return salvarProcesso(processoDTO);
    }

    private ProcessoDTO salvarProcesso(@NotNull(message = MSG_SERVICE_PROCESSO_NOT_EMPTY) ProcessoDTO processoDTO) {
        return this.processoConverter.converterEntidadeParaResponseDTO(super.repository.save(this.processoConverter.converterDTOParaEntidade(processoDTO)));
    }

    private ProcessoDTO atualizaSituacaoProcesso(Processo processo) {
        log.info("Atualizando situação do processo [{}] para [{}]", processo.getNumeroProcesso());
        //processo.setCodigoSituacao(situacao);
        log.debug("Atualização da situação do processo realizado com sucesso...");
        return this.processoConverter.converterEntidadeParaResponseDTO(super.repository.save(processo));
    }

    public boolean existeProcesso(@NotEmpty(message = MSG_SERVICE_PROCESSO_NOT_EMPTY) String numeroProcesso,
                                  DominioStatusObjeto statusProcesso) {
        return super.repository.existsByNumeroProcessoAndStatusProcesso(numeroProcesso, statusProcesso);
    }

    public boolean existeProcesso(@NotEmpty(message = MSG_SERVICE_PROCESSO_NOT_EMPTY) String numeroProcesso) {
        return super.repository.existsByNumeroProcesso(numeroProcesso);
    }

    public ProcessoDTO obterPorId(Long id) {
        return this.processoConverter.converterEntidadeParaResponseDTO(this.repository.findById(id.toString()).get());
    }

    public ProcessoDTO convertEntityToDTO(Processo processo){
        return this.processoConverter.converterEntidadeParaResponseDTO(processo);
    }

    public Processo convertDTOToEntity(ProcessoDTO processoDTO) {
        return this.processoConverter.converterDTOParaEntidade(processoDTO);
    }

    public void validar(Processo processo) {

        if(processo.getNumeroProcesso() == null || processo.getNumeroProcesso().trim().equals("")) {
            throw new RegraNegocioException("Informe uma Número válido.");
        }
    }
}