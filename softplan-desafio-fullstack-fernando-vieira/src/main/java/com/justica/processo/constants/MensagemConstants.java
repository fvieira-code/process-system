package com.justica.processo.constants;

public interface MensagemConstants {
    /*Gerais*/
    String MSG_DUPLICATED_MESSAGE = "service.controleMensagem.duplicated.message";
    String MSG_PROPRIEDADE_DESCONHECIDA = "message.property_unrecognized";
    String MSG_REQUEST_BODY_MISSING = "requestBody.invalid.message";
    String MSG_REQUEST_PARAM_MISSING = "requestParam.missing.message";
    String MISSING_HEADER_MESSAGE = "exception.missing.header.message";
    String MSG_CONST_ERRO = "exception.objetonaoencontrado.error.message";
    String MSG_EMPRESA_SERVICE_NOT_NULL = "service.empresa.notnull.message";
    String MSG_LOG_COMPONENT_CORRELATION_ID_NOT_EMPTY = "log.component.correlationid.notempty.message";
    String MSG_LOG_COMPONENT_CORRELATION_ID_ERROR = "log.component.correlationid.error.message";
    String MSG_LOG_COMPONENT_CORRELATION_ID_RECOVERY_ERROR = "log.component.correlationid.recovery.error.message";
    String MSG_LOG_COMPONENT_CLEAR_MDC = "log.component.clear.mdc";
    String MSG_API_DICT_RESPONSE_ENTITY_NOT_NULL = "response.notnull.message";
    String MSG_TIPO_CHAVE_INVALIDA = "dto.chaverequest.tipochave.invalid.message";
    String MSG_TIPO_ENUM_INVALIDO = "validation.enum.generic.invalid.message";
    String MSG_CONVERTER_CLAIM_NOT_NULL = "converter.claim.notnull.message";
    String MSG_UUID_PATTERN_INVALID = "regex.uuid.pattern.invalid.message";

    /*Services*/
    String MSG_SERVICE_PESSOA_NOT_EMPTY = "service.pessoa.notempty.message";
    String MSG_SERVICE_ASSUNTO_NOT_EMPTY = "service.assunto.notempty.message";
    String MSG_SERVICE_USUARIO_NOT_EMPTY = "service.usuario.notempty.message";
    String MSG_SERVICE_PROCESSO_NOT_EMPTY = "service.processo.notempty.message";

    /*DTO*/
    String MSG_DTO_PESSOA_NOT_NULL = "dto.pessoa.notnull.message";
    String MSG_DTO_PESSOA_TIPO_PESSOA_NOT_NULL = "dto.pessoa.tipopessoa.notnull.message";
    String MSG_DTO_PESSOA_STATUS_PESSOA_NOT_NULL = "dto.pessoa.statuspessoa.notnull.message";
    String MSG_DTO_PESSOA_NOME_SIZE_INVALID = "dto.pessoa.nome.size.message";
    String MSG_DTO_PESSOA_NOME_NOT_EMPTY = "dto.pessoa.nome.notempty.message";
    String MSG_DTO_PESSOA_DOCUMENTO_NOT_EMPTY = "dto.pessoa.numerodocumento.notempty.message";

    String MSG_DTO_PARTE_DESCRICAO_NOT_NULL = "dto.parte.descricao.notnull.message";
    String MSG_DTO_PARTE_STATUS_NOT_NULL = "dto.parte.status.notnull.message";

    String MSG_DTO_PROCESSO_NOT_NULL = "dto.processo.notnull.message";
    String MSG_DTO_PROCESSO_NUMERO_NOT_EMPTY = "dto.processo.numeroprocesso.notempty.message";
    String MSG_DTO_PROCESSO_DATA_DISTRIBUICAO_NOT_EMPTY = "dto.processo.datadistribuicaoprocesso.notempty.message";
    String MSG_DTO_PROCESSO_DATA_NOT_EMPTY = "dto.processo.data.notempty.message";
    String MSG_DTO_PROCESSO_STATUS_PROCESSO_NOT_NULL = "dto.processo.status.notempty.message";
    String MSG_DTO_PROCESSO_NUMERO_INQUERITO_NOT_EMPTY = "dto.processo.numeroinoqueritopolicial.notempty.message";
    String MSG_DTO_PROCESSO_CAUSA_NOT_EMPTY = "dto.processo.causa.notempty.message";
    String MSG_DTO_PROCESSO_AUTUACAO_NOT_EMPTY = "dto.processo.autuacao.notempty.message";
    String MSG_DTO_PROCESSO_SEGREDO_JUSTICAO_NOT_EMPTY = "dto.processo.segredojustica.notempty.message";
    String MSG_DTO_PROCESSO_VOLUME_NOT_EMPTY = "dto.processo.volume.notempty.message";
    String MSG_DTO_PROCESSO_NUMERO_PAGINA_NOT_EMPTY = "dto.processo.numeropagina.notempty.message";
    String MSG_DTO_PROCESSO_PRIORIDADE_NOT_EMPTY = "dto.processo.prioridade.notempty.message";
    String MSG_DTO_PROCESSO_GRATUIDADE_NOT_EMPTY = "dto.processo.gratuidade.notempty.message";
    String MSG_DTO_PROCESSO_FUNDAMENTACAO_NOT_EMPTY = "dto.processo.fundamentacao.notempty.message";

    String MSG_DTO_INSTANCIA_PROCESSO_NOT_NULL = "dto.instancia.processo.notempty.message";
    String MSG_DTO_AREA_PROCESSO_NOT_NULL = "dto.area.processo.notempty.message";
    String MSG_DTO_SITUACAO_PROCESSO_NOT_NULL = "dto.situacao.processo.notempty.message";
    String MSG_DTO_COMARCA_PROCESSO_NOT_NULL = "dto.comarca.processo.notempty.message";
    String MSG_DTO_VARA_PROCESSO_NOT_NULL = "dto.vara.processo.notempty.message";
    String MSG_DTO_GABINETE_PROCESSO_NOT_NULL = "dto.gabinete.processo.notempty.message";
    String MSG_DTO_SECRETARIA_PROCESSO_NOT_NULL = "dto.secretaria.processo.notempty.message";
    String MSG_DTO_MAGISTRADO_PROCESSO_NOT_NULL = "dto.magistrado.processo.notempty.message";
    String MSG_DTO_COMPETENCIA_PROCESSO_NOT_NULL = "dto.competencia.processo.notempty.message";
    String MSG_DTO_CLASSE_PROCESSO_NOT_NULL = "dto.classe.processo.notempty.message";
    String MSG_DTO_ASSUNTO_PROCESSO_NOT_NULL = "dto.assunto.processo.notempty.message";
    String MSG_DTO_INSTITUICAO_PROCESSO_NOT_NULL = "dto.instituicao.processo.notempty.message";

    /*Exception*/
    String MSG_EXCEPTION_VALOR_INVALIDO = "exception.valorinvalido.message";

    /*Entidades*/
    String MSG_ENTITY_PESSOA_NOT_NULL = "entity.pessoa.notnull.message";
    String MSG_ENTITY_CORRELATION_ID_NOT_EMPTY = "entity.correlationId.notempty";
    String MSG_ENTITY_CODIGO_USUARIO_NOT_EMPTY = "entity.codigoUsuario.notempty";
    String MSG_ENTITY_PROPRIETARIO_NOT_NULL = "entity.pessoa.notnull.message";
    String MSG_ENTITY_OBJECT_MENSAGEM_NOT_NULL = "entity.object.notnull";
    String MSG_ENTITY_PESSOA_MENSAGEM_NOT_EMPTY = "entity.pessoa.mensagem.notempty";

    String MSG_ENTITY_INSTANCIA_MENSAGEM_NOT_EMPTY = "entity.instancia.mensagem.notempty";
    String MSG_ENTITY_INSTANCIA_NOT_NULL = "entity.instancia.mensagem.notnull";

    String MSG_ENTITY_ASSUNTO_MENSAGEM_NOT_EMPTY = "entity.assunto.mensagem.notempty";
    String MSG_ENTITY_ASSUNTO_NOT_NULL = "entity.pessoa.notnull.message";

    String MSG_ENTITY_USUARIO_MENSAGEM_NOT_EMPTY = "entity.usuario.mensagem.notempty";
    String MSG_ENTITY_USUARIO_NOT_NULL = "entity.usuario.notnull.message";

    String MSG_ENTITY_PROCESS_MENSAGEM_NOT_EMPTY = "entity.processo.mensagem.notempty";
    String MSG_ENTITY_PROCESSO_NOT_NULL = "entity.processo.notnull.message";

    /*Controllers*/
    String MSG_REST_REQUEST_BODY_NOT_NULL = "rest.body.notnull.message";
    String MSG_REST_HEADER_CORRELATIONID_NOT_EMPTY = "rest.correlationid.notempty.message";
    String MSG_REST_PESSOA_ESCLUIDA_SUCESSO = "rest.pessoa.excluida.sucesso.message";

    /*Enum*/

    /*Strings repetidas Log*/
    String MSG_LOG_PROCESSO_REQUEST = "Request: [{}]";
    String MSG_LOG_PROCESSO_RESPONSE = "Response: [{}]";
}
