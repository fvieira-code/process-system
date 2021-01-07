package com.justica.processo.converter;

import com.justica.processo.component.LogComponente;
import com.justica.processo.model.Usuario;
import com.justica.processo.model.dto.rest.request.UsuarioRequestDTO;
import com.justica.processo.model.dto.rest.response.UsuarioResponseDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

import static com.justica.processo.constants.MensagemConstants.MSG_ENTITY_USUARIO_MENSAGEM_NOT_EMPTY;

@Log4j2
@Validated
@Component
@Getter(AccessLevel.PROTECTED)
public class UsuarioConverter {

    private final ModelMapper modelMapper;
    private final LogComponente logComponente;

    UsuarioConverter(ModelMapper modelMapper, LogComponente logComponente) {
        this.modelMapper = modelMapper;
        this.logComponente = logComponente;
    }

    public Usuario converterDTOParaEntidade(@NotNull(message = MSG_ENTITY_USUARIO_MENSAGEM_NOT_EMPTY) UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = this.getModelMapper().map(usuarioRequestDTO, Usuario.class);
        return usuario;
    }

    public UsuarioResponseDTO converterEntidadeParaResponseDTO(@NotNull(message = MSG_ENTITY_USUARIO_MENSAGEM_NOT_EMPTY) Usuario usuario){
        UsuarioResponseDTO usuarioResponseDTO = this.getModelMapper().map(usuario, UsuarioResponseDTO.class);
        return usuarioResponseDTO;
    }
}
