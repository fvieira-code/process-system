package com.justica.processo.model.dto.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justica.processo.model.domain.DominioStatusObjeto;
import com.justica.processo.model.dto.rest.RestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssuntoRequestDTO implements RestDTO {
    //@Schema(description = "CPF da pessoa", type = "string", required = true)
    @NotEmpty(message = "dto.assunto.descricao.notempty.message")
    private String descricaoAssunto;

    @NotEmpty(message = "dto.objeto.status.notempty.message")
    private DominioStatusObjeto statusAssunto;

    @JsonIgnore
    private String correlationId;
    @JsonIgnore
    private String codigoUsuario;

    @Override
    public String getInformation() {
        return this.getCodigoUsuario().concat(this.getCorrelationId());
    }
}
