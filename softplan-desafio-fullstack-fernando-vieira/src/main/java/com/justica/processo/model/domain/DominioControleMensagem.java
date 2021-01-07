package com.justica.processo.model.domain;

import com.justica.processo.exception.ValorInvalidoException;
import lombok.Getter;

import static com.justica.processo.constants.MensagemConstants.MSG_EXCEPTION_VALOR_INVALIDO;

public enum DominioControleMensagem {
    INICIADO("INICIADO"),
    FINALIZADO("FINALIZADO"),
    PROCESSADO("PROCESSADO"),
    FALHA("FALHA");

    @Getter
    private String value;

    DominioControleMensagem(String value) {
        this.value = value;
    }

    public static DominioControleMensagem fromValue(String text) {
        for (DominioControleMensagem b : DominioControleMensagem.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new ValorInvalidoException(MSG_EXCEPTION_VALOR_INVALIDO, text);
    }

    public boolean isIniciado(){return INICIADO.equals(this);}
    public boolean isFinalizado(){return  FINALIZADO.equals(this);}
    public boolean isProcessado(){return PROCESSADO.equals(this);}
    public boolean isFalha(){return FALHA.equals(this);}
}
