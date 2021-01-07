package com.justica.processo.rest.controller.v1;

import com.justica.processo.model.Pessoa;
import com.justica.processo.model.Situacao;
import com.justica.processo.model.domain.DominioControleMensagem;
import com.justica.processo.model.domain.DominioStatusPessoa;
import com.justica.processo.model.domain.DominioTipoPessoa;
import com.justica.processo.model.dto.rest.PessoaDTO;
import com.justica.processo.model.dto.rest.response.PessoaPFResponseDTO;
import com.justica.processo.service.ControleMensagemService;
import com.justica.processo.service.PessoaService;
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
@RequestMapping(URI_PESSOA_V1)
public class PessoaController extends AbstractController{

    private final PessoaService pessoaService;
    private final UsuarioService usuarioService;
    private final ProcessoService processoService;

    @Autowired
    public PessoaController(ControleMensagemService controleMensagemService,
                            PessoaService pessoaService, UsuarioService usuarioService, ProcessoService processoService) {
        super(controleMensagemService);
        this.pessoaService = pessoaService;
        this.usuarioService = usuarioService;
        this.processoService = processoService;
    }

    @GetMapping(path = {URI_SITUACAO_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    public ResponseEntity obterListaSituacao (){
        List<Situacao> situacao = this.processoService.obterListaSituacao();
        return ResponseEntity.ok(situacao);
    }

    @GetMapping("{id}")
    public PessoaDTO  obterPessoa( @PathVariable("id") Long id ) {
        return this.pessoaService.obterPorId(id);
    }

    @GetMapping(path = {URI_PESSOA_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Consultar Pessoa", authorizations = {@Authorization(value = "Authorization")})

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = PessoaPFResponseDTO.class)
    })
    public ResponseEntity  consultarPessoa(@RequestParam(value ="numeroDocumento" , required = false) String numeroDocumento,
                                           @RequestParam(value ="nomePessoa" , required = false) String nomePessoa,
                                           @RequestParam(value ="tipoPessoa", required = false) DominioTipoPessoa tipoPessoa,
                                           @RequestParam(value ="statusPessoa" , required = false) DominioStatusPessoa statusPessoa,
                                           @RequestParam(value ="codigoUsuario", required = false) String codigoUsuario,
                                           @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                           @RequestHeader HttpHeaders headers) {

        log.info("Iniciando consulta da pessoa [{}]...", tipoPessoa);

        Pessoa pessoaFiltro = new Pessoa();
        pessoaFiltro.setNumeroDocumento(numeroDocumento);
        pessoaFiltro.setNomePessoa(nomePessoa);
        pessoaFiltro.setTipoPessoa(tipoPessoa);
        pessoaFiltro.setStatusPessoa(statusPessoa);
        pessoaFiltro.setCodigoUsuario(codigoUsuario);

        String uri = this.getUriNormalizada(URI_PESSOA_V1.concat(URI_PESSOA_CONSULTAR_PATH));
        PessoaDTO pessoaDTO = this.pessoaService.convertEntityToDTO(pessoaFiltro);
        pessoaDTO.setCorrelationId(correlationId);
        this.salvarControleMensagem(pessoaDTO, headers, HttpMethod.GET, uri, DominioControleMensagem.INICIADO);
        List<Pessoa> pessoa = this.pessoaService.consultarPessoa(pessoaFiltro);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping(produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Incluir Pessoa", authorizations = {@Authorization(value = "Authorization")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = PessoaPFResponseDTO.class)
    })
    public ResponseEntity<PessoaDTO> incluirPessoa(@NotNull(message = MSG_REST_REQUEST_BODY_NOT_NULL) @RequestBody PessoaDTO pessoaPFRequestDTO,
                                                   @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                                   @RequestHeader HttpHeaders headers) {
        log.info("Iniciando inclusão da pessoa [{}]...");

        String uri = this.getUriNormalizada(URI_PESSOA_V1.concat(URI_PESSOA_INCLUIR_PATH));
        this.salvarControleMensagem(pessoaPFRequestDTO, headers, HttpMethod.POST, uri, DominioControleMensagem.INICIADO);
        PessoaDTO response = this.pessoaService.incluirPessoa(pessoaPFRequestDTO);
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
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = PessoaPFResponseDTO.class)
    })
    public ResponseEntity<PessoaDTO> alterarPessoa(@NotNull(message = MSG_REST_REQUEST_BODY_NOT_NULL) @RequestBody PessoaDTO pessoaDTO,
                                                   @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                                   @RequestHeader HttpHeaders headers) {
        log.info("Iniciando alteração da pessoa [{}]...", pessoaDTO.getNumeroDocumento());
        pessoaDTO.setCorrelationId(correlationId);
        String uri = this.getUriNormalizada(URI_PESSOA_ALTERAR_PATH);
        this.salvarControleMensagem(pessoaDTO, headers, HttpMethod.PUT, uri, DominioControleMensagem.INICIADO);
        PessoaDTO response =  this.pessoaService.alterarPessoa(pessoaDTO, pessoaDTO.getStatusPessoa());
        this.salvarControleMensagem(response, headers, HttpMethod.PUT, uri, DominioControleMensagem.PROCESSADO);
        return ok(response);
    }

    @PutMapping(path = {URI_PESSOA_REMOVER_PATH},  produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Excluir Pessoa", authorizations = {@Authorization(value = "Authorization")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = PessoaPFResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = PessoaPFResponseDTO.class)
    })
    public ResponseEntity<PessoaDTO> excluirPessoa(@NotNull(message = MSG_REST_REQUEST_BODY_NOT_NULL) @RequestBody PessoaDTO pessoaDTO,
                                                   @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                                   @RequestHeader HttpHeaders headers) {
        log.info("Iniciando exclusão da pessoa [{}]...", pessoaDTO.getNumeroDocumento());
        pessoaDTO.setCorrelationId(correlationId);
        String uri = this.getUriNormalizada(URI_PESSOA_REMOVER_PATH);
        this.salvarControleMensagem(pessoaDTO, headers, HttpMethod.DELETE, uri, DominioControleMensagem.INICIADO);
        PessoaDTO response = this.pessoaService.excluirPessoa(pessoaDTO);
        this.salvarControleMensagem(response, headers, HttpMethod.DELETE, uri, DominioControleMensagem.PROCESSADO);
        return ok(response);
    }
}
