package com.justica.processo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.thymeleaf.util.StringUtils;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "controlemensagem")
public class ControleMensagem extends AbstractEntity {
    @Id
    @Column(name = "codigouid", nullable = false, unique = true)
    private String uuid;

    @PrePersist
    void prePersist() {
        if (StringUtils.isEmpty(this.uuid)) {
            this.uuid = UUID.randomUUID().toString();
        }
    }

    public ControleMensagem( String codigoUsuario,  String correlationId) {
        super.setCodigoUsuario(codigoUsuario);
        super.setCorrelationId(correlationId);
    }
}
