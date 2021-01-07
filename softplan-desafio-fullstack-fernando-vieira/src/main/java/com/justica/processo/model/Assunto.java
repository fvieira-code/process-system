package com.justica.processo.model;

import com.justica.processo.model.domain.DominioStatusObjeto;
import com.justica.processo.model.domain.DominioStatusPessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "assunto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Assunto extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoass", nullable = false, unique = true, length = 100)
    private String id;

    @Size(max = 100, message = "entity.assunto.descricao.size.message")
    @Column(name = "descricaoass", nullable = false, length = 100)
    private String descricaoAssunto;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusass", length = 10, insertable = true, updatable = true)
    private DominioStatusObjeto statusAssunto;

    @PrePersist
    public void prePersist() {
        if (Strings.isEmpty(this.id)) {
            this.id = UUID.randomUUID().toString();
        }
    }
}