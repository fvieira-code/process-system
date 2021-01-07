package com.justica.processo.constants;

public interface LiteralConstants {
    String REGEX_EMAIL = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    String REGEX_TELEFONE = "^\\+[1-9][0-9]\\d{1,14}$";
    String REGEX_CPF = "^[0-9]{11}$";
    String REGEX_CNPJ = "^[0-9]{14}$";
    String REGEX_RAZAO_OPER_CONSULTA_PESSOA = "SOLICITACAO_USUARIO";
    String REGEX_RAZAO_OPER_REMOVE_PESSOA = "SOLICITACAO_USUARIO|INATIVIDADE_PESSOA|EXPURGO_PESSOA";
    String REGEX_RAZAO_OPER_INCLUI_PESSOA = "SOLICITACAO_USUARIO";
    String REGEX_RAZAO_OPER_ATUALIZAR_PESSOA = "SOLICITACAO_USUARIO";
    String PATTERN_OFFSET_DATE_TIME_CONVERTER = "yyyy-MM-dd HH:mm:ss.nnnnnnn xxx";
    String PATTERN_OFFSET_DATE_TIME_SERIALIZER = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    String LOG_MSG_RESPONSE = "Response: [{}]";
    String LOG_MSG_REQUEST = "Request: [{}]";
    String LOG_CORRELATION_ID = "correlationId";
    String REGEX_STRING_FORMAT = "[%s]";
    String ZONE_ID_PADRAO = "Z";
    String PATTERN_DATA_RETURN = "dd/MM/yyyy";
    String VARIAVEL_SISTEMA = "Variavel de Sistema";
    String CID_SEPARATOR = "&";
    String REGEX_MDC_CORRELATION_ID = "\\[|\\]";

    String REGEX_RAZAO_OPER_CONSULTA_OBJETO = "SOLICITACAO_USUARIO";
}
