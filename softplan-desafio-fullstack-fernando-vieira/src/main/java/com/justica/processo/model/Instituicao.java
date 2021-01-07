package com.justica.processo.model;

import com.justica.processo.model.domain.DominioStatusObjeto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "instituicao")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Instituicao extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoins", nullable = false, unique = true)
    private String id;

    @Size(max = 100, message = "entity.situacao.descricao.size.message")
    @Column(name = "descricaoins", nullable = false, length = 100)
    private String descricaoInstituicao;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusins", length = 20, insertable = false, updatable = false)
    private DominioStatusObjeto statusInstituicao;

    @PrePersist
    public void prePersist() {
        if (Strings.isEmpty(this.id)) {
            this.id = UUID.randomUUID().toString();
        }
    }
}