package com.justica.processo.model.domain;

import com.justica.processo.exception.ValorInvalidoException;
import lombok.Getter;

import static com.justica.processo.constants.MensagemConstants.MSG_EXCEPTION_VALOR_INVALIDO;

public enum DominioStatus {
    ATIVO("ATIVO"),
    CANCELADO("CANCELADO"),
    EXCLUIDO("EXCLUIDO");

    @Getter
    private String value;

    DominioStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name();
    }

    public static DominioStatus fromValue(String text) {
        for (DominioStatus b : DominioStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new ValorInvalidoException(MSG_EXCEPTION_VALOR_INVALIDO, text);
    }

    public boolean isAtivo(){return ATIVO.equals(this);}
    public boolean isCancelado(){return CANCELADO.equals(this);}
    public boolean isExcluido(){return EXCLUIDO.equals(this);}
}
