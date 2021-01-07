import ApiService from '../apiservice'
import ErroValidacao from '../exception/ErroValidacao'

export default class ProcessoService extends ApiService {

    constructor(){
        super('/processos')
    }

    obterListaStatus(){
        return  [

            { label: 'Selecione...', value: '' },
            { label: 'ATIVO', value: 'ATIVO'},
            { label: 'INATIVO', value: 'INATIVO'},
            { label: 'EXCLUIDO', value: 'EXCLUIDO'},
            { label: 'PENDENTE', value: 'PENDENTE'},
            { label: 'EFETIVADO', value: 'EFETIVADO'},
            { label: 'CANCELADO', value: 'CANCELADO'},
            { label: 'ALTERADO', value: 'ALTERADO'}

        ]
    }

    obterListaBoolean(){
        return  [
            { label: 'Selecione...', value: '' },
            { label: 'Sim' , value : 'SIM' },
            { label: 'Não' , value : 'NAO' }
        ]
    }

    obterListaInstancia(){
        return  this.get(`/instancia`);
    }

    obterListaComarca(){
        return  this.get(`/comarca`);
    }
    
    obterListaSituacao(){
        return  this.get(`/situacao`);
    }

    obterListaArea(){
        return  this.get(`/area`);
    }

    obterListaVara(){
        return  this.get(`/vara`);
    }

    obterListaGabinete(){
        return  this.get(`/gabinete`);
    }

    obterListaSecretaria(){
        return  this.get(`/secretaria`);
    }

    obterListaMagistrado(){
        return  this.get(`/magistrado`);
    }

    obterListaCompetencia(){
        return  this.get(`/competencia`);
    }

    obterListaClasse(){
        return  this.get(`/classe`);
    }

    obterListaAssunto(){
        return  this.get(`/assunto`);
    }

    obterListaInstituicao(){
        return  this.get(`/instituicao`);
    }

    obterPorId(id){
        return this.get(`/${id}`);
    }

    atualizarProcesso(processo){
        return this.put(`/${processo.id}`, processo);
    }

    alterarProcesso(processo){
        return this.put('/', processo)
    }

    excluirProcesso(processo){
        return this.put('/remover/', processo)
    }

    validar(processo){
        const erros = [];

        if(!processo.numeroProcesso){
            erros.push("Informe o Nome.")
        }

        if(!processo.codigoInstancia){
            erros.push("Informe a Instância do Processo.")
        }

        if(!processo.codigoArea){
            erros.push("Informe a Área do Processo.")
        }

        if(!processo.codigoSituacao){
            erros.push("Informe a Situação do Processo.")
        }

        if(!processo.codigoArea){
            erros.push("Informe a Área do Processo.")
        }

        if(!processo.codigoVara){
            erros.push("Informe a Vara do Processo.")
        }

        if(!processo.codigoGabinete){
            erros.push("Informe a Gabinete do Processo.")
        }

        if(!processo.codigoSecretaria){
            erros.push("Informe a Secretaria do Processo.")
        }

        if(!processo.codigoMagistrado){
            erros.push("Informe a Magistrado do Processo.")
        }

        if(!processo.codigoCompetencia){
            erros.push("Informe a Competência do Processo.")
        }

        if(!processo.codigoClasse){
            erros.push("Informe a Classe do Processo.")
        }

        if(!processo.codigoAssunto){
            erros.push("Informe a Assunto do Processo.")
        }

        if(!processo.codigoInstituicao){
            erros.push("Informe a Instituição do Processo.")
        }

        if(erros && erros.length > 0){
            throw new ErroValidacao(erros);
        }
    }

    incluirProcesso(processo){ 
        return this.post('/', processo)   
        }

    consultarProcesso(processoFiltro){
        let params = `?statusProcesso=${processoFiltro.statusProcesso}`

        if(processoFiltro.numeroProcesso){
            params = `${params}&numeroProcesso=${processoFiltro.numeroProcesso}`
        }

        if(processoFiltro.codigoUsuario){
            params = `${params}&codigoUsuario=${processoFiltro.codigoUsuario}`
        }

        return this.get(`/consultar${params}`);
    }

}