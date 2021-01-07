package com.justica.processo.model;

import com.justica.processo.model.domain.DominioStatusPessoa;
import com.justica.processo.model.domain.DominioTipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "FISICA")
public class PessoaFisica extends Pessoa {
    //@CPF(message = "entity.pessoa.numerodocumento.cpf.invalid.message")
    //@Pattern(regexp = "^[0-9]{11}", message = "entity.pessoa.numerodocumento.invalid.message")
    //@NotEmpty(message = "entity.pessoa.numerodocumento.notempty.message")
    @Column(name = "cpfcnpjpes", nullable = false, length = 14)
    private String numeroDocumento;

    @Column(name = "nomepes", length = 100)
    private String nomePessoa;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipopes", length = 8, insertable = false, updatable = false)
    private DominioTipoPessoa tipoPessoa;

    @Enumerated(EnumType.STRING)
    @Column(name = "statuspes", length = 100, insertable = true, updatable = true)
    private DominioStatusPessoa statusPessoa;

    @Column(name = "codigousu", nullable = false)
    private String codigoUsuario;

    @Column(name = "codigocid", nullable = true)
    private String correlationId;
}
