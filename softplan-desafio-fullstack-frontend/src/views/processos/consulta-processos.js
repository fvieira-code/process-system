import React from 'react'
import { withRouter } from 'react-router-dom'
import Card from '../../components/card'
import FormGroup from '../../components/form-group'
import SelectMenu from '../../components/selectMenu'
import ProcessosTable from './processoTable'
import ProcessoService from '../../app/service/processoService'
import LocalStorageService from '../../app/service/localstorageService'
import * as messages from '../../components/toastr'

class ConsultaProcessos extends React.Component {

    state = {
        processos  : [],       
        numeroProcesso: '',
        statusProcesso: '',
        codigoSituacao: '', 
        codigoUsuario: '',
        situacaoProcesso: []
    }

    constructor(){
        super();
        this.service = new ProcessoService();
    }   

    componentDidMount(){
        this.service.obterListaSituacao().then(response => {
            this.setState({ situacaoProcesso: response.data });
        });       
    }

    consultaProcessos = () => {
        const usuarioLogado = LocalStorageService.obterItem('_usuario_logado');
        
        const processoFiltro = {
            numeroProcesso: this.state.numeroProcesso,
            statusProcesso: this.state.statusProcesso,
            codigoUsuario: usuarioLogado.id
        }

        this.service
            .consultarProcesso(processoFiltro)
            .then( resposta => {
                const lista = resposta.data;
                
                if(lista.length < 1){
                    messages.mensagemAlert("Nenhum resultado encontrado.");
                }
                this.setState({ processos: lista })
            }).catch( error => {
                console.log(error)
            })
    }

    preparaFormularioCadastro = () => {
        this.props.history.push('/cadastro-processos')
    }

    editarProcesso = (id) => {
        this.props.history.push(`/cadastro-processos/${id}`)
    }
    

    alterarProcesso = (processo, statusProcesso) => {
        this.service
            .alterarProcesso(processo)
            .then( response => {
                const processos = this.state.processos;
                const index = processos.indexOf(processo);
                if(index !== -1){
                    processo['status'] = statusProcesso;
                    processos[index] = processo
                    this.setState({processo});
                }
                messages.mensagemSucesso("Status atualizado com sucesso!")
            })
    }

    excluirProcesso = (processo,  statusProcesso) => {
        this.service
            .excluirProcesso(processo)
            .then( response => {
                const processos = this.state.processos;
                const index = processos.indexOf(processo);
                if(index !== -1){
                    processo['status'] = statusProcesso;
                    processos[index] = processo
                    this.setState({processo});
                }
                    messages.mensagemSucesso('Processo excluído com sucesso!')
            })
    }

    render(){

        const status = this.service.obterListaStatus();
        
        return (
            <Card title="Consulta Processos">
                <div className="row">
                    <div className="col-md-6">
                        <div className="bs-component">
                            <FormGroup htmlFor="inputNumeroProcesso" label="Número Processo: ">
                                <input type="text" 
                                       className="form-control" 
                                       id="inputNumeroProcesso" 
                                       value={this.state.numeroProcesso}
                                       onChange={e => this.setState({numeroProcesso: e.target.value})}
                                       />
                            </FormGroup>

                            <FormGroup htmlFor="inputStatus" label="Status Processo: ">
                                <SelectMenu id="inputStatus" 
                                            value={this.state.statusProcesso}
                                            onChange={e => this.setState({statusProcesso: e.target.value})}
                                            className="form-control" 
                                            lista={status} />
                            </FormGroup>

                            <button onClick={this.preparaFormularioCadastro} 
                                    type="button" 
                                    className="btn btn-danger">
                                    <i className="pi pi-plus"></i> Cadastrar
                            </button>

                            <button onClick={this.consultaProcessos} 
                                    type="button" 
                                    className="btn btn-success">
                                    <i className="pi pi-search"></i> Consultar
                            </button>
                        </div>                        
                    </div>
                </div>   
                <br/ >
                <div className="row">
                    <div className="col-md-12">
                        <div className="bs-component">
                            <ProcessosTable processos={this.state.processos} 
                                              editarProcesso={this.editarProcesso}
                                              alterarProcesso={this.alterarProcesso} 
                                              excluirProcesso={this.excluirProcesso}/>
                        </div>
                    </div>  
                </div>                     
            </Card>
        )
    }
}

export default withRouter(ConsultaProcessos);