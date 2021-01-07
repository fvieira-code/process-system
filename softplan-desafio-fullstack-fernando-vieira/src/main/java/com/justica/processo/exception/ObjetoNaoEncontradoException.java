package com.justica.processo.exception;

import lombok.Getter;

public class ObjetoNaoEncontradoException extends RuntimeException  {
    @Getter
    private final String[] args;

    public ObjetoNaoEncontradoException(String message, String... args) {
        super(message);
        this.args = args;
    }
}
