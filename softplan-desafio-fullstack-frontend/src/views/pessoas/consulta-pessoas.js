import React from 'react'
import { withRouter } from 'react-router-dom'
import Card from '../../components/card'
import FormGroup from '../../components/form-group'
import SelectMenu from '../../components/selectMenu'
import PessoasTable from './pessoaTable'
import PessoaService from '../../app/service/pessoaService'
import LocalStorageService from '../../app/service/localstorageService'
import * as messages from '../../components/toastr'

class ConsultaPessoas extends React.Component {

    state = {
        pessoas : [],       
        numeroDocumento: '',
        nomePessoa: '', 
        tipoPessoa: '',
        statusPessoa: '',
        codigoUsuario: ''
    }

    constructor(){
        super();
        this.service = new PessoaService();
    }   

    consultaPessoas = () => {
        if(!this.state.tipoPessoa){
            messages.mensagemErro('O preenchimento do campo tipo pessoa é obrigatório.')
            return false;
        }

        const usuarioLogado = LocalStorageService.obterItem('_usuario_logado');
        
        const pessoaFiltro = {
            numeroDocumento: this.state.numeroDocumento,
            nomePessoa: this.state.nomePessoa,
            tipoPessoa: this.state.tipoPessoa,
            statusPessoa: this.state.statusPessoa,
            codigoUsuario: usuarioLogado.id
        }

        this.service
            .consultarPessoa(pessoaFiltro)
            .then( resposta => {
                const lista = resposta.data;
                
                if(lista.length < 1){
                    messages.mensagemAlert("Nenhum resultado encontrado.");
                }
                this.setState({ pessoas: lista })
            }).catch( error => {
                console.log(error)
            })
    }

    preparaFormularioCadastro = () => {
        this.props.history.push('/cadastro-pessoas')
    }

    editarPessoa = (id) => {
        this.props.history.push(`/cadastro-pessoas/${id}`)
    }
    

    alterarPessoa = (pessoa, statusPessoa) => {
        this.service
            .alterarPessoa(pessoa)
            .then( response => {
                const pessoas = this.state.pessoas;
                const index = pessoas.indexOf(pessoa);
                if(index !== -1){
                    pessoa['status'] = statusPessoa;
                    pessoas[index] = pessoa
                    this.setState({pessoa});
                }
                messages.mensagemSucesso("Status atualizado com sucesso!")
            })
    }

    excluirPessoa = (pessoa,  statusPessoa) => {
        this.service
            .excluirPessoa(pessoa)
            .then( response => {
                const pessoas = this.state.pessoas;
                const index = pessoas.indexOf(pessoa);
                if(index !== -1){
                    pessoa['status'] = statusPessoa;
                    pessoas[index] = pessoa
                    this.setState({pessoa});
                }
                    messages.mensagemSucesso('Pessoa excluída com sucesso!')
            })
    }

    render(){
        
        const tipos = this.service.obterListaTipos();
        const status = this.service.obterListaStatus();

        return (
            <Card title="Consulta Pessoas">
                <div className="row">
                    <div className="col-md-6">
                        <div className="bs-component">
                            <FormGroup htmlFor="inputDocumento" label="Documento: ">
                                <input type="text" 
                                       className="form-control" 
                                       id="inputDocumento" 
                                       value={this.state.numeroDocumento}
                                       onChange={e => this.setState({numeroDocumento: e.target.value})}
                                       />
                            </FormGroup>
                                                    
                            <FormGroup htmlFor="inputNome" label="Nome: ">
                                <input type="text" 
                                       className="form-control" 
                                       id="inputNome" 
                                       value={this.state.nomePessoa}
                                       onChange={e => this.setState({nomePessoa: e.target.value})}
                                       />
                            </FormGroup>
   
                            <FormGroup htmlFor="inputTipo" label="Tipo Pessoa: ">
                                <SelectMenu id="inputTipo" 
                                            value={this.state.tipoPessoa}
                                            onChange={e => this.setState({ tipoPessoa: e.target.value })}
                                            className="form-control" 
                                            lista={tipos} />
                            </FormGroup>

                            <FormGroup htmlFor="inputStatus" label="Status Pessoa: ">
                                <SelectMenu id="inputStatus" 
                                            value={this.state.statusPessoa}
                                            onChange={e => this.setState({statusPessoa: e.target.value})}
                                            className="form-control" 
                                            lista={status} />
                            </FormGroup>
                           
                            <button onClick={this.preparaFormularioCadastro} 
                                    type="button" 
                                    className="btn btn-danger">
                                    <i className="pi pi-plus"></i> Cadastrar
                            </button>

                            <button onClick={this.consultaPessoas} 
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
                            <PessoasTable pessoas={this.state.pessoas} 
                                              editarPessoa={this.editarPessoa}
                                              alterarPessoa={this.alterarPessoa} 
                                              excluirPessoa={this.excluirPessoa}/>
                        </div>
                    </div>  
                </div>                     
            </Card>
        )
    }
}

export default withRouter(ConsultaPessoas);
