package com.justica.processo.rest.controller.v1;

import com.justica.processo.model.*;
import com.justica.processo.model.domain.DominioControleMensagem;
import com.justica.processo.model.domain.DominioStatusObjeto;
import com.justica.processo.model.dto.rest.ProcessoDTO;
import com.justica.processo.model.dto.rest.response.ProcessoResponseDTO;
import com.justica.processo.service.ControleMensagemService;
import com.justica.processo.service.ProcessoService;
import com.justica.processo.service.UsuarioService;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.justica.processo.constants.MensagemConstants.MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY;
import static com.justica.processo.constants.MensagemConstants.MSG_REST_REQUEST_BODY_NOT_NULL;
import static com.justica.processo.constants.VariavelSistemaConstants.*;
import static org.springframework.http.ResponseEntity.ok;

@Log4j2
@Validated
@RestController
@RequestMapping(URI_PROCESSO_V1)
public class ProcessoController extends AbstractController{

    private final ProcessoService processoService;
    private final UsuarioService usuarioService;

    @Autowired
    public ProcessoController(ControleMensagemService controleMensagemService,
                              ProcessoService processoService, UsuarioService usuarioService) {
        super(controleMensagemService);
        this.processoService = processoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping(path = {URI_INSTANCIA_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaInstancia (){
        List<Instancia> instancia = this.processoService.obterListaInstancia();
        return ResponseEntity.ok(instancia);
    }

    @GetMapping(path = {URI_AREA_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaArea (){
        List<Area> situacao = this.processoService.obterListaArea();
        return ResponseEntity.ok(situacao);
    }

    @GetMapping(path = {URI_COMARCA_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaComarca () {
        List<Comarca> comarca = this.processoService.obterListaComarca();
        return ResponseEntity.ok(comarca);
    }

    @GetMapping(path = {URI_SITUACAO_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaSituacao (){
        List<Situacao> situacao = this.processoService.obterListaSituacao();
        return ResponseEntity.ok(situacao);
    }

    @GetMapping(path = {URI_VARA_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaVara () {
        List<Vara> vara = this.processoService.obterListaVara();
        return ResponseEntity.ok(vara);
    }

    @GetMapping(path = {URI_GABINETE_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaGabinete (){
        List<Gabinete> gabinete = this.processoService.obterListaGabinete();
        return ResponseEntity.ok(gabinete);
    }

    @GetMapping(path = {URI_SECRETARIA_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaSecretaria (){
        List<Secretaria> secretaria = this.processoService.obterListaSecretaria();
        return ResponseEntity.ok(secretaria);
    }

    @GetMapping(path = {URI_MAGISTRADO_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaMagistrado (){
        List<Magistrado> magistrado = this.processoService.obterListaMagistrado();
        return ResponseEntity.ok(magistrado);
    }

    @GetMapping(path = {URI_COMPETENCIA_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaCompetencia (){
        List<Competencia> competencia = this.processoService.obterListaCompetencia();
        return ResponseEntity.ok(competencia);
    }

    @GetMapping(path = {URI_CLASSE_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaClasse (){
        List<Classe> classe = this.processoService.obterListaClasse();
        return ResponseEntity.ok(classe);
    }

    @GetMapping(path = {URI_ASSUNTO_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaAssunto (){
        List<Assunto> assunto = this.processoService.obterListaAssunto();
        return ResponseEntity.ok(assunto);
    }

    @GetMapping(path = {URI_INSTITUICAO_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaInstituicao (){
        List<Instituicao> instituicao = this.processoService.obterListaInstituicao();
        return ResponseEntity.ok(instituicao);
    }

    @GetMapping("{id}")
    public ProcessoDTO obterProcesso(@PathVariable("id") Long id ) {
        return this.processoService.obterPorId(id);
    }

    @GetMapping(path = {URI_PROCESSO_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Consultar Processo", authorizations = {@Authorization(value = "Authorization")})

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = ProcessoResponseDTO.class)
    })
    public ResponseEntity  consultarPessoa(@RequestParam(value ="numeroProcesso" , required = false) String numeroProcesso,
                                           @RequestParam(value ="statusProcesso" , required = false) DominioStatusObjeto statusProcesso,
                                           @RequestParam(value ="codigoUsuario", required = false) String codigoUsuario,
                                           @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                           @RequestHeader HttpHeaders headers) {

        log.info("Iniciando consulta do processo [{}]...", numeroProcesso);
        List<Processo> processo;
        if (numeroProcesso != null && statusProcesso == null) {
            processo = this.processoService.obterProcessoPorNumero(numeroProcesso); }
        else if (numeroProcesso == null && statusProcesso != null) {
                processo = this.processoService.obterProcessoPorStatus(statusProcesso);
        } else if (numeroProcesso != null && statusProcesso != null) {
            processo = this.processoService.obterProcessoPorNumeroPorStatus(numeroProcesso, statusProcesso);
        } else { processo = this.processoService.obterListaProcesso(); }

        String uri = this.getUriNormalizada(URI_PROCESSO_V1.concat(URI_PROCESSO_CONSULTAR_PATH));
        ProcessoDTO processoDTO = this.processoService.convertEntityToDTO(processo.get(0));
        processoDTO.setCorrelationId(correlationId);
        this.salvarControleMensagem(processoDTO, headers, HttpMethod.GET, uri, DominioControleMensagem.INICIADO);
        return ok(processo);
    }

    @PostMapping(produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Incluir Processo", authorizations = {@Authorization(value = "Authorization")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = ProcessoResponseDTO.class)
    })
    public ResponseEntity<ProcessoDTO> incluirProcesso(@NotNull(message = MSG_REST_REQUEST_BODY_NOT_NULL) @RequestBody ProcessoDTO processoDTO,
                                                   @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                                   @RequestHeader HttpHeaders headers) {
        log.info("Iniciando inclusão do processo [{}]...");

        String uri = this.getUriNormalizada(URI_PROCESSO_V1.concat(URI_PROCESSO_INCLUIR_PATH));
        this.salvarControleMensagem(processoDTO, headers, HttpMethod.POST, uri, DominioControleMensagem.INICIADO);
        ProcessoDTO response = this.processoService.incluirProcesso(processoDTO);
        return ok(response);
    }

    @PutMapping(produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Alterar Pessoa", authorizations = {@Authorization(value = "Authorization")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = ProcessoResponseDTO.class)
    })
    public ResponseEntity<ProcessoDTO> alterarProcesso(@NotNull(message = MSG_REST_REQUEST_BODY_NOT_NULL) @RequestBody ProcessoDTO processoDTO,
                                                   @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                                   @RequestHeader HttpHeaders headers) {
        log.info("Iniciando alteração do processo [{}]...", processoDTO.getNumeroProcesso());
        processoDTO.setCorrelationId(correlationId);
        String uri = this.getUriNormalizada(URI_PROCESSO_ALTERAR_PATH);
        this.salvarControleMensagem(processoDTO, headers, HttpMethod.PUT, uri, DominioControleMensagem.INICIADO);
        ProcessoDTO response =  this.processoService.alterarProcesso(processoDTO, processoDTO.getStatusProcesso());
        this.salvarControleMensagem(response, headers, HttpMethod.PUT, uri, DominioControleMensagem.PROCESSADO);
        return ok(response);
    }

    @PutMapping(path = {URI_PROCESSO_REMOVER_PATH},  produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Excluir Processo", authorizations = {@Authorization(value = "Authorization")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = ProcessoResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = ProcessoResponseDTO.class)
    })
    public ResponseEntity<ProcessoDTO> excluirProcesso(@NotNull(message = MSG_REST_REQUEST_BODY_NOT_NULL) @RequestBody ProcessoDTO processoDTO,
                                                   @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                                   @RequestHeader HttpHeaders headers) {
        log.info("Iniciando exclusão do processo [{}]...", processoDTO.getNumeroProcesso());
        processoDTO.setCorrelationId(correlationId);
        String uri = this.getUriNormalizada(URI_PESSOA_REMOVER_PATH);
        this.salvarControleMensagem(processoDTO, headers, HttpMethod.DELETE, uri, DominioControleMensagem.INICIADO);
        ProcessoDTO response = this.processoService.excluirProcesso(processoDTO, processoDTO.getStatusProcesso());
        this.salvarControleMensagem(response, headers, HttpMethod.DELETE, uri, DominioControleMensagem.PROCESSADO);
        return ok(response);
    }
}
