package com.justica.processo.model.domain;
import com.justica.processo.exception.ValorInvalidoException;
import lombok.Getter;

public enum DominioTipoPessoa {

    FISICA("FISICA"),
    JURIDICA("JURIDICA");

    @Getter
    private String value;

    DominioTipoPessoa(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name();
    }

    public static DominioTipoPessoa fromValue(String text) {
        for (DominioTipoPessoa b : DominioTipoPessoa.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new ValorInvalidoException(ValorInvalidoException.MSG_VALOR_INVALIDO, text);
    }
}
