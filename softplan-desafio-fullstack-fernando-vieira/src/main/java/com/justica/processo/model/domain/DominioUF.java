package com.justica.processo.model.domain;

import com.justica.processo.exception.ValorInvalidoException;
import lombok.Getter;

import static com.justica.processo.constants.MensagemConstants.MSG_EXCEPTION_VALOR_INVALIDO;

public enum DominioUF {
    PA("PARÁ"),
    SC("SANTA CANTARIAN"),
    SP("SÃO PAULO"),
    RJ("RIO DE JANEIRO"),
    PR("PARANÁ");

    @Getter
    private String value;

    DominioUF(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name();
    }

    public static DominioUF fromValue(String text) {
        for (DominioUF b : DominioUF.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new ValorInvalidoException(MSG_EXCEPTION_VALOR_INVALIDO, text);
    }

    public boolean isPara(){return PA.equals(this);}
    public boolean isSanta_Catarina(){return SC.equals(this);}
    public boolean isSaoPaulo(){return SP.equals(this);}
    public boolean isRio_De_Janreiro(){return RJ.equals(this);}
    public boolean isParana(){return PR.equals(this);}
}
