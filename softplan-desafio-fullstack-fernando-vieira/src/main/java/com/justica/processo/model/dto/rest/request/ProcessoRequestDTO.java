package com.justica.processo.model.dto.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justica.processo.model.Situacao;
import com.justica.processo.model.domain.DominioStatusObjeto;
import com.justica.processo.model.dto.rest.ProcessoDTO;
import com.justica.processo.model.dto.rest.RestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static com.justica.processo.constants.MensagemConstants.MSG_DTO_PROCESSO_NUMERO_NOT_EMPTY;
import static com.justica.processo.constants.MensagemConstants.MSG_DTO_SITUACAO_PROCESSO_NOT_NULL;
import static com.justica.processo.constants.MensagemConstants.MSG_DTO_PROCESSO_STATUS_PROCESSO_NOT_NULL;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProcessoRequestDTO extends ProcessoDTO implements RestDTO {

    @NotEmpty(message = MSG_DTO_PROCESSO_NUMERO_NOT_EMPTY)
    private String numeroProcesso;

    @NotNull(message = MSG_DTO_PROCESSO_STATUS_PROCESSO_NOT_NULL)
    private DominioStatusObjeto statusProcesso;

    @NotNull(message = MSG_DTO_SITUACAO_PROCESSO_NOT_NULL)
    private Situacao codigoSituacao;

    @JsonIgnore
    private String correlationId;
    @JsonIgnore
    private String codigoUsuario;

}
