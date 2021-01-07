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
@Table(name = "magistrado")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Magistrado extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigomag", nullable = false, unique = true)
    private String id;

    @Size(max = 100, message = "entity.situacao.descricao.size.message")
    @Column(name = "descricaomag", nullable = false, length = 100)
    private String descricaoMagistrado;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusmag", length = 20, insertable = false, updatable = false)
    private DominioStatusObjeto statusMagistrado;

    @PrePersist
    public void prePersist() {
        if (Strings.isEmpty(this.id)) {
            this.id = UUID.randomUUID().toString();
        }
    }
}