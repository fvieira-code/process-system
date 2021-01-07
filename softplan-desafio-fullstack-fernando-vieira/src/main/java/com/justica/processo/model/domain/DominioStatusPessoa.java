package com.justica.processo.model.domain;

import com.justica.processo.exception.ValorInvalidoException;
import lombok.Getter;

import static com.justica.processo.constants.MensagemConstants.MSG_EXCEPTION_VALOR_INVALIDO;

public enum DominioStatusPessoa {
    ATIVO("ACTIVE"),
    INATIVO("INACTIVE"),
    EXCLUIDO("EXCLUDED"),
    PENDENTE("PENDENTE"),
    EFETIVADO("EFETIVADO"),
    CANCELADO("CANCELADO");

    @Getter
    private String value;

    DominioStatusPessoa(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name();
    }

    public static DominioStatusPessoa fromValue(String text) {
        for (DominioStatusPessoa b : DominioStatusPessoa.values()) {
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
}
