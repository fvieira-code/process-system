package com.justica.processo.model.dto.rest.request;

import com.justica.processo.model.domain.DominioStatusObjeto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class UsuarioRequestDTO {

    //@Schema(description = "CPF da pessoa", type = "string", required = true)
    @NotEmpty(message = "dto.usuario.nome.notempty.message")
    private String nomeUsuario;

    @NotEmpty(message = "dto.usuario.email.notempty.message")
    private String emailUsuario;

    @NotEmpty(message = "entity.usuario.senha.notempty.message")
    private String senhaUsuario;

    //@NotEmpty(message = "dto.objeto.status.notempty.message")
    //private DominioStatusObjeto statusUsuario;

    private Date dataCadastro;
}
