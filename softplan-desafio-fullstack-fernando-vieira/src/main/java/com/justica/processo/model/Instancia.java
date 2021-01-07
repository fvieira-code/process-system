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
@Table(name = "instancia")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Instancia extends AbstractEntity {
    public Instancia(){

    }

    public Instancia(int i){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoint", nullable = false, unique = true)
    private String id;

    @Size(max = 100, message = "entity.instancia.descricao.size.message")
    @Column(name = "descricaoint", nullable = false, length = 100)
    private String descricaoInstancia;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusint", length = 20, insertable = false, updatable = false)
    private DominioStatusObjeto statusSituacao;

    @PrePersist
    public void prePersist() {
        if (Strings.isEmpty(this.id)) {
            this.id = UUID.randomUUID().toString();
        }
    }
}