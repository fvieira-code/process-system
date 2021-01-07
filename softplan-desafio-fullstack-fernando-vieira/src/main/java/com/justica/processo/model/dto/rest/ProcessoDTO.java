package com.justica.processo.model.dto.rest;

import com.justica.processo.model.*;
import com.justica.processo.model.domain.DominioStatusObjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Convert;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.justica.processo.constants.MensagemConstants.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessoDTO implements RestDTO {
	private Long id;
	@NotEmpty(message = MSG_DTO_PROCESSO_NUMERO_NOT_EMPTY)
	private String numeroProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_DATA_DISTRIBUICAO_NOT_EMPTY)
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate datadistribuicaoProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_NUMERO_INQUERITO_NOT_EMPTY)
	private String numeroInqueritoPolicialProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_CAUSA_NOT_EMPTY)
	private BigDecimal valorCausaProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_CAUSA_NOT_EMPTY)
	private DominioStatusObjeto statusProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_AUTUACAO_NOT_EMPTY)
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataAutuacaoProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_SEGREDO_JUSTICAO_NOT_EMPTY)
	private String segredoJusticaProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_VOLUME_NOT_EMPTY)
	private Integer volumeProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_NUMERO_PAGINA_NOT_EMPTY)
	private Integer numeroPaginaProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_PRIORIDADE_NOT_EMPTY)
	private String prioridadeProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_GRATUIDADE_NOT_EMPTY)
	private String gratuidadeProcesso;
	@NotEmpty(message= MSG_DTO_PROCESSO_FUNDAMENTACAO_NOT_EMPTY)
	private String fundamentacaoProcesso;
	@NotNull(message = MSG_DTO_AREA_PROCESSO_NOT_NULL)
	private Area codigoArea;
	@NotNull(message = MSG_DTO_SITUACAO_PROCESSO_NOT_NULL)
	private Situacao codigoSituacao;
	@NotNull(message = MSG_DTO_INSTANCIA_PROCESSO_NOT_NULL)
	private Instancia codigoInstancia;
	@NotNull(message = MSG_DTO_COMARCA_PROCESSO_NOT_NULL)
	private Comarca codigoComarca;
	@NotNull(message = MSG_DTO_VARA_PROCESSO_NOT_NULL)
	private Vara codigoVara;
	@NotNull(message = MSG_DTO_GABINETE_PROCESSO_NOT_NULL)
	private Gabinete codigoGabinete;
	@NotNull(message = MSG_DTO_SECRETARIA_PROCESSO_NOT_NULL)
	private Secretaria codigoSecretaria;
	@NotNull(message = MSG_DTO_MAGISTRADO_PROCESSO_NOT_NULL)
	private Magistrado codigoMagistrado;
	@NotNull(message = MSG_DTO_COMPETENCIA_PROCESSO_NOT_NULL)
	private Competencia codigoCompetencia;
	@NotNull(message = MSG_DTO_CLASSE_PROCESSO_NOT_NULL)
	private Classe codigoClasse;
	@NotNull(message = MSG_DTO_ASSUNTO_PROCESSO_NOT_NULL)
	private Assunto codigoAssunto;
	@NotNull(message = MSG_DTO_INSTITUICAO_PROCESSO_NOT_NULL)
	private Instituicao codigoInstituicao;

	@Size(max = 100, message = MSG_ENTITY_CODIGO_USUARIO_NOT_EMPTY)
	private String codigoUsuario;
	@Size(max = 100, message = MSG_ENTITY_CORRELATION_ID_NOT_EMPTY)
	private String correlationId;

	@Override
	public String getInformation() {
		return this.getCodigoUsuario().concat(this.getCorrelationId());
	}
}
