package com.justica.processo.model;

import com.justica.processo.model.domain.DominioStatusObjeto;
import lombok.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "processo", schema = "db-softplan-desafio-fullstack-001")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Processo extends AbstractEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "codigopro", nullable = false, unique = true)
        private String id;

        @Column(name="codigocnj", nullable = false, length = 25)
        private String numeroProcesso;

        @Column(name="datadistpro", nullable = false)
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
        private LocalDate datadistribuicaoProcesso;

        @Column(name="numeroinqpol", nullable = false)
        private String numeroInqueritoPolicialProcesso;

        @Column(name="valorpro", nullable = false)
        private BigDecimal valorCausaProcesso;

        @Column(name="statuspro", nullable = false)
        private DominioStatusObjeto statusProcesso;

        @Column(name="dataautupro", nullable = false)
        @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
        private LocalDate dataAutuacaoProcesso;

        @Column(name="segredopro", nullable = false, length = 15)
        private String segredoJusticaProcesso;

        @Column(name="volumepro", nullable = false)
        private Integer volumeProcesso;

        @Column(name="paginapro", nullable = false)
        private Integer numeroPaginaProcesso;

        @Column(name="prioridadepro", nullable = false, length = 15)
        private String prioridadeProcesso;

        @Column(name="gratuidadepro", nullable = false, length = 15)
        private String gratuidadeProcesso;

        @Column(name="fundamentopro", nullable = false)
        private String fundamentacaoProcesso;

        @ManyToOne
        @JoinColumn(name= "codigoint")
        private Instancia codigoInstancia;

        @ManyToOne
        @JoinColumn(name = "codigocmc")
        private Comarca codigoComarca;

        @ManyToOne
        @JoinColumn(name = "codigosit")
        private Situacao codigoSituacao;

        @ManyToOne
        @JoinColumn(name = "codigoare")
        private Area codigoArea;

        @ManyToOne
        @JoinColumn(name= "codigovar")
        private Vara codigoVara;

        @ManyToOne
        @JoinColumn(name = "codigogab")
        private Gabinete codigoGabinete;

        @ManyToOne
        @JoinColumn(name = "codigosec")
        private Secretaria codigoSecretaria;

        @ManyToOne
        @JoinColumn(name = "codigomag")
        private Magistrado codigoMagistrado;

        @ManyToOne
        @JoinColumn(name= "codigocom")
        private Competencia codigoCompetencia;

        @ManyToOne
        @JoinColumn(name = "codigocla")
        private Classe codigoClasse;

        @ManyToOne
        @JoinColumn(name = "codigoass")
        private Assunto codigoAssunto;

        @ManyToOne
        @JoinColumn(name = "codigoins")
        private Instituicao codigoInstituicao;

        @PrePersist
        public void prePersist() {
                if (Strings.isEmpty(this.id)) {
                        this.id = UUID.randomUUID().toString();
                }
    }
}
