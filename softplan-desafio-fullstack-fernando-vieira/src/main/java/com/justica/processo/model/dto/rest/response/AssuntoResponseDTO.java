package com.justica.processo.model.dto.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justica.processo.model.domain.DominioStatusObjeto;
import com.justica.processo.model.dto.rest.PessoaDTO;
import com.justica.processo.model.dto.rest.RestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssuntoResponseDTO implements RestDTO {

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
        return codigoUsuario.concat(correlationId);
    }
}
