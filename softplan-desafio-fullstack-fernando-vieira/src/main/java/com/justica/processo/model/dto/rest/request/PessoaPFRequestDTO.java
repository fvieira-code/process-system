package com.justica.processo.model.dto.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justica.processo.model.domain.DominioStatusPessoa;
import com.justica.processo.model.domain.DominioTipoPessoa;
import com.justica.processo.model.dto.rest.PessoaDTO;
import com.justica.processo.model.dto.rest.RestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.justica.processo.constants.LiteralConstants.REGEX_CPF;
import static com.justica.processo.constants.MensagemConstants.*;

@Data
@EqualsAndHashCode(callSuper = false)
public class PessoaPFRequestDTO extends PessoaDTO implements RestDTO {
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

    @JsonIgnore
    private String correlationId;
    @JsonIgnore
    private String codigoUsuario;
}
