package com.justica.processo.model;

import com.justica.processo.model.domain.DominioStatusPessoa;
import com.justica.processo.model.domain.DominioTipoPessoa;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.logging.log4j.util.Strings;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipopes", discriminatorType = DiscriminatorType.STRING)
public class Pessoa extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "codigopes", nullable = false, unique = true, length = 100)
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Size(max = 100, message = "entity.pessoa.nome.size.message")
    @Column(name = "nomepes", nullable = false, length = 100)
    private String nomePessoa;

    @Column(name="cpfcnpjpes", nullable = false, length = 14)
    private String numeroDocumento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipopes", length = 8, insertable = false, updatable = false)
    private DominioTipoPessoa tipoPessoa;

    @Enumerated(EnumType.STRING)
    @Column(name = "statuspes", length = 10, insertable = true, updatable = true)
    private DominioStatusPessoa statusPessoa;

    @PrePersist
    public void prePersist() {
        if (Strings.isEmpty(this.id)) {
            this.id = UUID.randomUUID().toString();
        }
    }
}