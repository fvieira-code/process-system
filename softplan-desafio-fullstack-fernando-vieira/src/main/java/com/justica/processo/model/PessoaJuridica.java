package com.justica.processo.model;

import com.justica.processo.model.domain.DominioStatusPessoa;
import com.justica.processo.model.domain.DominioTipoPessoa;
import com.justica.processo.validation.CNPJ;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "JURIDICA")
public class PessoaJuridica extends Pessoa {
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
