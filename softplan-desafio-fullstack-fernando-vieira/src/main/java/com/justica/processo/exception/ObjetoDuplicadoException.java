package com.justica.processo.exception;

import lombok.Getter;

import static com.justica.processo.constants.MensagemConstants.MSG_DUPLICATED_MESSAGE;

public class ObjetoDuplicadoException extends AbstractProcessoException {

    @Getter
    private final String[] objetoMensagem;

    public ObjetoDuplicadoException(String... objetoMensagem) {
        super(MSG_DUPLICATED_MESSAGE, objetoMensagem);
        this.objetoMensagem = objetoMensagem;
    }

    public ObjetoDuplicadoException(Throwable cause, String... objetoMensagem) {
        super(MSG_DUPLICATED_MESSAGE, cause, null);
        this.objetoMensagem = objetoMensagem;
    }
}
