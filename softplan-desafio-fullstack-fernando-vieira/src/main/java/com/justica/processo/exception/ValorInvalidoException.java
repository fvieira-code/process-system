package com.justica.processo.exception;

public class ValorInvalidoException extends AbstractProcessoException {
    public static final String MSG_VALOR_INVALIDO = "exception.valorinvalido.message";

    public ValorInvalidoException(String message, String... args) {
        super(message, args);
    }

    public ValorInvalidoException(String message, Throwable cause, String... args) {
        super(message, cause, args);
    }
}
