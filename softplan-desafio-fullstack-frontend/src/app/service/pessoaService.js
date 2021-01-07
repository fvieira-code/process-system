import ApiService from '../apiservice'
import ErroValidacao from '../exception/ErroValidacao'

export default class PessoaService extends ApiService {

    constructor(){
        super('/pessoas')
    }

    obterListaTipos(){
        return  [
            { label: 'Selecione...', value: '' },
            { label: 'Fisica' , value : 'FISICA' },
            { label: 'Jurídica' , value : 'JURIDICA' }
        ]
    }

    obterListaStatus(){
        return  [
            { label: 'Selecione...', value: '' },
            { label: 'Pendente' , value : 'PENDENTE' },
            { label: 'Efetivado' , value : 'EFETIVADO' },
            { label: 'Cancelado' , value : 'CANCELADO' },
            { label: 'Excluido' , value : 'EXCLUIDO' }
        ]
    }

    obterListaSituacao(){
        return this.get(`/situacao`);
    }

    obterPorId(id){
        return this.get(`/${id}`);
    }

    atualizarPessoa(pessoa){
        return this.put(`/${pessoa.id}`, pessoa);
    }

    alterarPessoa(pessoa){
        return this.put('/', pessoa)
    }

    excluirPessoa(pessoa){
        return this.put('/remover/', pessoa)
    }

    validar(pessoa){
        const erros = [];

        if(!pessoa.nomePessoa){
            erros.push("Informe o Nome.")
        }

        if(!pessoa.numeroDocumento){
            erros.push("Informe o Documento.")
        }

        if(!pessoa.tipoPessoa){
            erros.push("Informe o Tipo.")
        }

        if(!pessoa.statusPessoa){
            erros.push("Informe o Status.")
        }

        if(erros && erros.length > 0){
            throw new ErroValidacao(erros);
        }
    }

    incluirPessoa(pessoa){ 
        return this.post('/', pessoa)   
        }

    consultarPessoa(pessoaFiltro){
        let params = `?tipoPessoa=${pessoaFiltro.tipoPessoa}`

        if(pessoaFiltro.nomePessoa){
            params = `${params}&nomePessoa=${pessoaFiltro.nomePessoa}`
        }

        if(pessoaFiltro.numeroDocumento){
            params = `${params}&numeroDocumento=${pessoaFiltro.numeroDocumento}`
        }

        if(pessoaFiltro.statusPessoa){
            params = `${params}&statusPessoa=${pessoaFiltro.statusPessoa}`
        }

        if(pessoaFiltro.codigoUsuario){
            params = `${params}&codigoUsuario=${pessoaFiltro.codigoUsuario}`
        }

        return this.get(`/consultar${params}`);
    }

}