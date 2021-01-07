package com.justica.processo.rest.controller.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justica.processo.model.ControleMensagem;
import com.justica.processo.model.domain.DominioControleMensagem;
import com.justica.processo.model.dto.rest.RestDTO;
import com.justica.processo.service.ControleMensagemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Log4j2
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class AbstractController {
    private final ControleMensagemService controleMensagemService;

    @Autowired
    public AbstractController(ControleMensagemService controleMensagemService) {
        this.controleMensagemService = controleMensagemService;
    }
    protected void salvarControleMensagem(RestDTO restDTO,  HttpHeaders headers,
                                          HttpMethod metodo, String uri, DominioControleMensagem situacao) {

        ControleMensagem controleMensagem = new ControleMensagem( restDTO.getCodigoUsuario(),
                restDTO.getCorrelationId());

        if (DominioControleMensagem.FINALIZADO.equals(situacao)) {
            log.info("Finalizando inclusão da pessoa [{}]...");
        }

        this.controleMensagemService.processarMensagem(controleMensagem);
    }

    protected String getUriNormalizada(String... uris) {
        StringBuilder uri = new StringBuilder();
        String before = null;

        for (String current : uris) {
            if (before == null) {
                before = current;
            } else {
                if (before.endsWith("/") && current.startsWith("/")) {
                    current = current.replaceFirst("/", "");
                } else if (!before.endsWith("/") && !current.startsWith("/")) {
                    current = "/".concat(current);
                }
                uri.append(before.replace(" ", ""));
                before = current;
            }
        }
        if (before != null) {
            uri.append(before.replace(" ", ""));
        }

        return uri.toString();
    }


    private String toJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e);
            return object.toString();
        }
    }

    protected final String getUsuario() {
        /*
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        KeycloakAuthenticationToken tokenPrincipal = (KeycloakAuthenticationToken) authentication;
        SimpleKeycloakAccount account = (SimpleKeycloakAccount)tokenPrincipal.getAccount();
        return account.getKeycloakSecurityContext().getToken().getName();*/
        return "fvieira";
    }
}
