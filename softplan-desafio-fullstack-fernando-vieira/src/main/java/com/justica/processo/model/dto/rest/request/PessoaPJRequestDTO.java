package com.justica.processo.model.dto.rest.request;

import com.justica.processo.validation.CNPJ;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.justica.processo.constants.LiteralConstants.REGEX_CNPJ;

@Data
@EqualsAndHashCode(callSuper = false)
public class PessoaPJRequestDTO {
    //@Schema(description = "CNPJ da pessoa", type = "string", required = true)
    @CNPJ(message = "dto.pessoa.numerodocumento.cnpj.invalid.message")
    @Pattern(regexp = REGEX_CNPJ, message = "dto.pessoa.numerodocumento.invalid.message")
    @NotEmpty(message = "dto.pessoa.numerodocumento.notempty.message")
    private String numeroDocumento;

    @Size(max = 100, message = "dto.pessoa.nome.notempty.message")
    private String nomeFantasia;
}
