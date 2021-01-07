package com.justica.processo.rest.controller.v1;

import com.justica.processo.model.domain.DominioControleMensagem;
import com.justica.processo.model.domain.DominioStatusObjeto;
import com.justica.processo.model.dto.rest.request.AssuntoRequestDTO;
import com.justica.processo.model.dto.rest.response.AssuntoResponseDTO;
import com.justica.processo.service.AssuntoService;
import com.justica.processo.service.ControleMensagemService;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static com.justica.processo.constants.LiteralConstants.REGEX_RAZAO_OPER_CONSULTA_OBJETO;
import static com.justica.processo.constants.MensagemConstants.*;
import static com.justica.processo.constants.VariavelSistemaConstants.*;
import static org.springframework.http.ResponseEntity.ok;

@Log4j2
@Validated
@RestController
@RequestMapping(URI_ASSUNTO_V1)
public class AssuntoController extends AbstractController{

    private final AssuntoService assuntoService;

    @Autowired
    public AssuntoController(ControleMensagemService controleMensagemService,
                             AssuntoService assuntoService) {
        super(controleMensagemService);
        this.assuntoService = assuntoService;
    }

    @GetMapping(path = {URI_ASSUNTO_CONSULTAR_PATH}, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Consultar Pessoa", authorizations = {@Authorization(value = "Authorization")})

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = AssuntoResponseDTO.class)
    })
    public ResponseEntity<AssuntoResponseDTO>  consultarAssunto(@Valid @NotNull(message = MSG_ENTITY_ASSUNTO_NOT_NULL)
                                                                    @ApiParam(value = "Descrição do Assunto", required = true)
                                                                    @PathVariable(value = "descricaoassunto") String descricaoassunto,
                                                      @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                                      @RequestHeader HttpHeaders headers) {

        AssuntoRequestDTO assuntoRequestDTO = new AssuntoRequestDTO();
        assuntoRequestDTO.setCorrelationId(correlationId);
        assuntoRequestDTO.setCodigoUsuario(super.getUsuario());
        assuntoRequestDTO.setDescricaoAssunto(descricaoassunto);
        assuntoRequestDTO.setStatusAssunto(DominioStatusObjeto.ATIVO);

        String uri = String.format("%s/%s/%s", URI_ASSUNTO_CONSULTAR_PATH, assuntoRequestDTO.getDescricaoAssunto(), REGEX_RAZAO_OPER_CONSULTA_OBJETO);
        this.salvarControleMensagem(assuntoRequestDTO, headers, HttpMethod.GET, uri, DominioControleMensagem.INICIADO);
        AssuntoResponseDTO response = this. assuntoService.consultarAssunto(assuntoRequestDTO);
        this.salvarControleMensagem(response, headers, HttpMethod.GET, uri, DominioControleMensagem.PROCESSADO);
        return ok(response);
    }

    @PostMapping(produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Incluir Assunto", authorizations = {@Authorization(value = "Authorization")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = AssuntoResponseDTO.class)
    })
    public ResponseEntity<AssuntoResponseDTO> incluirAssunto(@NotNull(message = MSG_REST_REQUEST_BODY_NOT_NULL) @RequestBody AssuntoRequestDTO assuntoRequestDTO,
                                                   @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                                   @RequestHeader HttpHeaders headers) {
        log.info("Iniciando inclusão do assunto [{}]...");

        assuntoRequestDTO.setStatusAssunto(DominioStatusObjeto.ATIVO);
        assuntoRequestDTO.setCorrelationId(correlationId);
        assuntoRequestDTO.setCodigoUsuario(super.getUsuario());

        String uri = this.getUriNormalizada(URI_ASSUNTO_V1.concat(URI_ASSUNTO_INCLUIR_PATH));
        this.salvarControleMensagem(assuntoRequestDTO, headers, HttpMethod.POST, uri, DominioControleMensagem.INICIADO);
        AssuntoResponseDTO response = this.assuntoService.incluirAssunto(assuntoRequestDTO);
        return ok(response);
    }

    @PutMapping(produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Alterar Assunto", authorizations = {@Authorization(value = "Authorization")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = AssuntoResponseDTO.class)
    })
    public ResponseEntity<AssuntoResponseDTO>  alterarAssunto(@NotNull(message = MSG_REST_REQUEST_BODY_NOT_NULL) @RequestBody AssuntoRequestDTO assuntoRequestDTO,
                                                              @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                                              @RequestHeader HttpHeaders headers) {
        log.info("Iniciando inclusão do assunto [{}]...");
        assuntoRequestDTO.setStatusAssunto(DominioStatusObjeto.ALTERADO);
        assuntoRequestDTO.setCorrelationId(correlationId);
        assuntoRequestDTO.setCodigoUsuario(super.getUsuario());
        String uri = this.getUriNormalizada(URI_ASSUNTO_ALTERAR_PATH);
        this.salvarControleMensagem(assuntoRequestDTO, headers, HttpMethod.PUT, uri, DominioControleMensagem.INICIADO);
        AssuntoResponseDTO response =  this.assuntoService.alterarAssunto(assuntoRequestDTO, DominioStatusObjeto.ALTERADO);
        this.salvarControleMensagem(response, headers, HttpMethod.PUT, uri, DominioControleMensagem.PROCESSADO);
        return ok(response);
    }

    @DeleteMapping(path = {URI_ASSUNTO_REMOVER_PATH},  produces = {MimeTypeUtils.APPLICATION_JSON_VALUE, "*/*;charset=UTF-8"})
    @ApiOperation(value = "Excluir Assunto", authorizations = {@Authorization(value = "Authorization")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-Correlation-Id", value = "Código transação",
                    required = true, paramType = "header", dataTypeClass = String.class),
            @ApiImplicitParam(name =  "Authorization", value = "Token autorização", required = true,
                    paramType = "header", dataTypeClass = String.class)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Operação realizada com sucesso", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 400, message = "Erro de validação", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 401, message = "Não autorizado", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 403, message = "Acesso proibido ao usuário", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 404, message = "Não encontrado", response = AssuntoResponseDTO.class),
            @ApiResponse(code = 500, message = "Erro interno", response = AssuntoResponseDTO.class)
    })
    public ResponseEntity<AssuntoResponseDTO> excluirAssunto(@NotNull(message = MSG_REST_REQUEST_BODY_NOT_NULL) @RequestBody AssuntoRequestDTO assuntoRequestDTO,
                                                              @NotEmpty(message = MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY) @RequestHeader(value = HEADER_CORRELATION_ID) String correlationId,
                                                              @RequestHeader HttpHeaders headers) {
        log.info("Iniciando exclusão da pessoa [{}]...");
        assuntoRequestDTO.setCorrelationId(correlationId);
        assuntoRequestDTO.setCodigoUsuario(super.getUsuario());
        String uri = this.getUriNormalizada(URI_ASSUNTO_REMOVER_PATH);
        this.salvarControleMensagem(assuntoRequestDTO, headers, HttpMethod.DELETE, uri, DominioControleMensagem.INICIADO);
        AssuntoResponseDTO response = this.assuntoService.excluirAssunto(assuntoRequestDTO, DominioStatusObjeto.EXCLUIDO);
        this.salvarControleMensagem(response, headers, HttpMethod.DELETE, uri, DominioControleMensagem.PROCESSADO);
        return ok(response);
    }
}
