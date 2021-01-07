package com.justica.processo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 7803570151736439484L;

    @Column(name = "codigousu", nullable = false)
    private String codigoUsuario;

    @Column(name = "codigocid", nullable = true)
    private String correlationId;

}
