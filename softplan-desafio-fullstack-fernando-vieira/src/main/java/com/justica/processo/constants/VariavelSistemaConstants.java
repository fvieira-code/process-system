package com.justica.processo.constants;

public interface VariavelSistemaConstants {
    /*URI*/
    String URI_PESSOA_V1 = "/api/v1/pessoas";
    String URI_PESSOA_CONSULTAR_PATH = "/consultar";
    String URI_PESSOA_INCLUIR_PATH = "/incluir";
    String URI_PESSOA_ALTERAR_PATH = "/alterar";
    String URI_PESSOA_REMOVER_PATH = "/remover/";

    String URI_ASSUNTO_V1 = "/api/v1/assunto";
    String URI_ASSUNTO_CONSULTAR_PATH = "/assunto";
    String URI_ASSUNTO_CONSULTAR_DESCRICAO_PATH = "/consultar/{descricaoassunto}";
    String URI_ASSUNTO_INCLUIR_PATH = "/incluir";
    String URI_ASSUNTO_ALTERAR_PATH = "/alterar";
    String URI_ASSUNTO_REMOVER_PATH = "/remover";

    String URI_USUARIO_V1 = "/api/v1/usuarios";
    String URI_USUARIO_CONSULTAR_PATH = "/consultar/{emailusuario}";
    String URI_USUARIO_INCLUIR_PATH = "/incluir";
    String URI_USUARIO_ALTERAR_PATH = "/alterar";
    String URI_USUARIO_REMOVER_PATH = "/remover";
    String URI_USUARIO_AUTENTICAR_PATH = "/autenticar";

    String URI_PROCESSO_V1 = "/api/v1/processos";
    String URI_PROCESSO_CONSULTAR_PATH = "/consultar";
    String URI_PROCESSO_INCLUIR_PATH = "/incluir";
    String URI_PROCESSO_ALTERAR_PATH = "/alterar";
    String URI_PROCESSO_REMOVER_PATH = "/remover/";
    String URI_PROCESSO_ALTERAR_PATH_ = "/alterar_";

    String URI_AREA_CONSULTAR_PATH = "/area";
    String URI_INSTANCIA_CONSULTAR_PATH = "/instancia";
    String URI_COMARCA_CONSULTAR_PATH = "/comarca";
    String URI_SITUACAO_CONSULTAR_PATH = "/situacao";
    String URI_VARA_CONSULTAR_PATH = "/vara";
    String URI_GABINETE_CONSULTAR_PATH = "/gabinete";
    String URI_SECRETARIA_CONSULTAR_PATH = "secretaria";
    String URI_MAGISTRADO_CONSULTAR_PATH = "/magistrado";
    String URI_COMPETENCIA_CONSULTAR_PATH = "/competencia";
    String URI_CLASSE_CONSULTAR_PATH = "/classe";
    String URI_INSTITUICAO_CONSULTAR_PATH = "/instituicao";
    String URI_PESSOA_PARTE_CONSULTAR_PATH = "/pessoa";

    /*Headers*/
    String HEADER_AUTHORIZATION_KEY = "Authorization";
    String HEADER_CORRELATION_ID = "X-Correlation-Id";

    /* Documentação */

}
