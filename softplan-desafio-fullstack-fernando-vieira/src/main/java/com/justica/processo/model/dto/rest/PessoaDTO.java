package com.justica.processo.model.dto.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justica.processo.model.domain.DominioStatusPessoa;
import com.justica.processo.model.domain.DominioTipoPessoa;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.justica.processo.constants.LiteralConstants.REGEX_CPF;
import static com.justica.processo.constants.MensagemConstants.MSG_DTO_PESSOA_NOME_SIZE_INVALID;
import static com.justica.processo.constants.MensagemConstants.MSG_DTO_PESSOA_TIPO_PESSOA_NOT_NULL;

@Data
public class PessoaDTO implements RestDTO {
    private Long id;
    //@Schema(description = "CPF da pessoa", type = "string", required = true)
    //@CPF(message = "dto.pessoa.numerodocumento.cpf.invalid.message")
    @Pattern(regexp = REGEX_CPF, message = "dto.pessoa.numerodocumento.invalid.message")
    @NotEmpty(message = "dto.pessoa.numerodocumento.notempty.message")
    private String numeroDocumento;

    @Size(max = 100, message = MSG_DTO_PESSOA_NOME_SIZE_INVALID)
    private String nomePessoa;

    @NotNull(message = MSG_DTO_PESSOA_TIPO_PESSOA_NOT_NULL)
    private DominioTipoPessoa tipoPessoa;

    @NotNull(message = MSG_DTO_PESSOA_TIPO_PESSOA_NOT_NULL)
    private DominioStatusPessoa statusPessoa;

    //@JsonIgnore
    @Size(max = 100, message = MSG_DTO_PESSOA_NOME_SIZE_INVALID)
    private String codigoUsuario;

    //@JsonIgnore
    @Size(max = 100, message = MSG_DTO_PESSOA_NOME_SIZE_INVALID)
    private String correlationId;

    @Override
    public String getInformation() {
        return this.getCodigoUsuario().concat(this.getCorrelationId());
    }

}


