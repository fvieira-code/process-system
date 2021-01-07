package com.justica.processo.model.domain;

import com.justica.processo.exception.ValorInvalidoException;
import lombok.Getter;

import static com.justica.processo.constants.MensagemConstants.MSG_EXCEPTION_VALOR_INVALIDO;

public enum DominioStatusObjeto {
    ATIVO("ACTIVE"),
    INATIVO("INACTIVE"),
    EXCLUIDO("EXCLUDED"),
    PENDENTE("PENDENTE"),
    EFETIVADO("EFETIVADO"),
    CANCELADO("CANCELADO"),
    ALTERADO("ALTERED");

    @Getter
    private String value;

    DominioStatusObjeto(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name();
    }

    public static DominioStatusObjeto fromValue(String text) {
        for (DominioStatusObjeto b : DominioStatusObjeto.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new ValorInvalidoException(MSG_EXCEPTION_VALOR_INVALIDO, text);
    }

    public boolean isAtivo(){return ATIVO.equals(this);}
    public boolean isInativo(){return INATIVO.equals(this);}
    public boolean isExcluido(){return EXCLUIDO.equals(this);}
    public boolean isPendente(){return PENDENTE.equals(this);}
    public boolean isEfetivado(){return EFETIVADO.equals(this);}
    public boolean isCancelado(){return CANCELADO.equals(this);}
    public boolean isAlterado(){return ALTERADO.equals(this);}
}
