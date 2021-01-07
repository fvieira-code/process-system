package com.justica.processo.exception;

import lombok.Getter;

import static com.justica.processo.constants.MensagemConstants.MSG_DUPLICATED_MESSAGE;

public class PessoaDuplicadoException extends AbstractProcessoException {

    @Getter
    private final String[] pessoaMensagem;

    public PessoaDuplicadoException(String... pessoaMensagem) {
        super(MSG_DUPLICATED_MESSAGE, pessoaMensagem);
        this.pessoaMensagem = pessoaMensagem;
    }

    public PessoaDuplicadoException(Throwable cause, String... pessoaMensagem) {
        super(MSG_DUPLICATED_MESSAGE, cause, null);
        this.pessoaMensagem = pessoaMensagem;
    }
}
