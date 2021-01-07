import React from 'react'

export default props => {

    const rows = props.pessoas.map( pessoa => {
        return (
            <tr key={pessoa.id}>
                <td>{pessoa.nomePessoa}</td>
                
                <td>{pessoa.numeroDocumento}</td>
                <td>{pessoa.tipoPessoa}</td>
                <td>{pessoa.statusPessoa}</td>
                <td>
                    <button className="btn btn-success" title="Efetivar"
                            disabled={ pessoa.statusPessoa !== 'PENDENTE' && pessoa.statusPessoa !== 'CANCELADO'}
                            onClick={e => props.alterarPessoa(pessoa, pessoa.statusPessoa = 'EFETIVADO')} 
                            type="button">
                            <i className="pi pi-check-square"></i>
                    </button>
                    <button type="button"   title="Editar"
                            className="btn btn-primary"
                            onClick={e => props.editarPessoa(pessoa.id)}>
                            <i className="pi pi-pencil"></i>
                    </button>
                    <button className="btn btn-warning"  title="Cancelar"
                            disabled={ pessoa.statusPessoa !== 'EFETIVADO' && pessoa.statusPessoa !== 'PENDENTE'}
                            onClick={e => props.alterarPessoa(pessoa, pessoa.statusPessoa = 'CANCELADO')} 
                            type="button">
                            <i className="pi pi-times"></i>
                    </button>
                    <button type="button"  title="Excluir"
                            className="btn btn-danger" 
                            disabled={ pessoa.statusPessoa !== 'EFETIVADO' && pessoa.statusPessoa !== 'PENDENTE'}
                            onClick={ e => props.excluirPessoa(pessoa, pessoa.statusPessoa = 'EXCLUIDO')}>
                            <i className="pi pi-trash"></i>
                    </button>
                </td>
            </tr>
        )
    } )

    return (
        <table className="table table-hover">
            <thead>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Documento</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Situação</th>
                    <th scope="col">Ações</th>
                </tr>
            </thead>
            <tbody>
                {rows}
            </tbody>
        </table>
    )
}

