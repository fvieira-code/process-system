package com.justica.processo.model;

import com.justica.processo.model.domain.DominioStatusObjeto;
import com.justica.processo.model.domain.DominioUF;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "comarca")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Comarca extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigocmc", nullable = false, unique = true)
    private String id;

    @Size(max = 100, message = "entity.instancia.descricao.size.message")
    @Column(name = "descricaocmc", nullable = false, length = 100)
    private String descricaoComarca;

    @Enumerated(EnumType.STRING)
    @Column(name = "ufcmc", length = 20, insertable = false, updatable = false)
    private DominioUF ufComarca;

    @PrePersist
    public void prePersist() {
        if (Strings.isEmpty(this.id)) {
            this.id = UUID.randomUUID().toString();
        }
    }
}