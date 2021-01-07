package com.justica.processo.exception;

import lombok.Getter;

public abstract class AbstractProcessoException extends RuntimeException {
    @Getter
    private final String[] args;

    public AbstractProcessoException(String mensagem) {
        super(mensagem);
        this.args = null;
    }

    public AbstractProcessoException(String message, String[] args) {
        super(message);
        this.args = args;
    }

    public AbstractProcessoException(String message, Throwable cause, String[] args) {
        super(message, cause);
        this.args = args;
    }
}
