package com.justica.processo.model.dto.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justica.processo.model.dto.rest.PessoaDTO;
import com.justica.processo.model.dto.rest.RestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper = false)
public class PessoaPFResponseDTO extends PessoaDTO implements RestDTO {

    //@Schema(description = "CPF da pessoa", type = "string", required = true)
    //@CPF(message = "dto.pessoa.numerodocumento.cpf.invalid.message")
    @Pattern(regexp = "^[0-9]{11}$", message = "dto.pessoa.numerodocumento.invalid.message")
    @NotEmpty(message = "dto.pessoa.numerodocumento.notempty.message")
    private String numeroDocumento;

    @JsonIgnore
    private String correlationId;
    @JsonIgnore
    private String codigoUsuario;
}
