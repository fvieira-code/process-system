package com.justica.processo.component;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.MDC;

import javax.validation.constraints.NotEmpty;

import static com.justica.processo.constants.LiteralConstants.LOG_CORRELATION_ID;
import static com.justica.processo.constants.LiteralConstants.REGEX_MDC_CORRELATION_ID;
import static com.justica.processo.constants.LiteralConstants.REGEX_STRING_FORMAT;
import static com.justica.processo.constants.MensagemConstants.MSG_LOG_COMPONENT_CLEAR_MDC;
import static com.justica.processo.constants.MensagemConstants.MSG_LOG_COMPONENT_CORRELATION_ID_ERROR;
import static com.justica.processo.constants.MensagemConstants.MSG_LOG_COMPONENT_CORRELATION_ID_NOT_EMPTY;
import static com.justica.processo.constants.MensagemConstants.MSG_LOG_COMPONENT_CORRELATION_ID_RECOVERY_ERROR;


@Log4j2
public class LogComponente {

    public void adicionarCorrelationIdMDC(@NotEmpty(message = MSG_LOG_COMPONENT_CORRELATION_ID_NOT_EMPTY) String correlationId) {
        try {
            MDC.put(LOG_CORRELATION_ID, String.format(REGEX_STRING_FORMAT, correlationId));
        } catch (Exception e) {
            log.warn(MSG_LOG_COMPONENT_CORRELATION_ID_ERROR, e);
        }
    }

    public void limparMDC() {
        try {
            if (this.getLogCorrelationId() != null)
                MDC.remove(LOG_CORRELATION_ID);
        } catch (Exception e) {
            log.warn(MSG_LOG_COMPONENT_CLEAR_MDC, e);
        }
    }

    public String getLogCorrelationId() {
        try {
            if (MDC.get(LOG_CORRELATION_ID) != null)
                return MDC.get(LOG_CORRELATION_ID).replaceAll(REGEX_MDC_CORRELATION_ID, Strings.EMPTY);
        } catch (Exception e) {
            log.warn(MSG_LOG_COMPONENT_CORRELATION_ID_RECOVERY_ERROR, e);
        }
        return null;
    }

}
