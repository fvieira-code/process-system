package com.justica.processo.model.dto.rest.response;

import com.justica.processo.model.dto.rest.RestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseErroDTO implements RestDTO {
    private static final long serialVersionUID = 1451435524967414929L;

    private String mensagemErro;
    private String detalheErro;

    private String correlationId;
    private String codigoUsuario;

    @Override
    public String getInformation() {
        return this.getCodigoUsuario().concat(this.getCorrelationId());
    }
}
