import React from 'react'
import Card from '../../components/card'
import FormGroup from '../../components/form-group'
import SelectMenu from '../../components/selectMenu'
import { withRouter } from 'react-router-dom'
import * as messages from '../../components/toastr'
import PessoaService from '../../app/service/pessoaService'
import LocalStorageService from '../../app/service/localstorageService'

class CadastroPessoas extends React.Component {

    state = {
        atualizando: false,
        numeroDocumento: '',
        nomePessoa: '',
        tipoPessoa: '',
        statusPessoa: '',
        correlationId: '',
        codigoUsuario: ''
    }

    constructor(){
        super();
        this.service = new PessoaService();
    }

    componentDidMount(){
        const params = this.props.match.params     
        if(params.id){
            this.service
                .obterPorId(params.id)
                .then(response => {
                    this.setState( {...response.data, atualizando: true} )
                })
                .catch(erros => {
                    messages.mensagemErro(erros.response.data)
                })
        }
    }

    incluir = () => {
        const usuarioLogado = LocalStorageService.obterItem('_usuario_logado')

        const { numeroDocumento, nomePessoa, tipoPessoa, statusPessoa } = this.state;
        const pessoas = { numeroDocumento, nomePessoa, tipoPessoa, statusPessoa, codigoUsuario: usuarioLogado.id, correlationId: 'SOLICITACAO_INCLUSAO'};

        try{
            this.service.validar(pessoas)
        }catch(erro){
            const mensagens = erro.mensagens;
            mensagens.forEach(msg => messages.mensagemErro(msg));
            return false;
        }     

        this.service
            .incluirPessoa(pessoas)
            .then(response => {
                this.props.history.push('/consulta-pessoas')
                messages.mensagemSucesso('Pessoa cadastrado com sucesso!')
            }).catch(error => {
                messages.mensagemErro(error.response.data)
            })
    }

    atualizar = () => {
        const usuarioLogado = LocalStorageService.obterItem('_usuario_logado')
        
        const { id, numeroDocumento, nomePessoa, tipoPessoa, statusPessoa } = this.state;
        const pessoas = { id, numeroDocumento, nomePessoa, tipoPessoa, statusPessoa, codigoUsuario: usuarioLogado.id, correlationId: 'SOLICITACAO_INCLUSAO'};
        
        this.service
            .alterarPessoa(pessoas)
            .then(response => {
                this.props.history.push('/consulta-pessoas')
                messages.mensagemSucesso('Pessoa atualizado com sucesso!')
            }).catch(error => {
                messages.mensagemErro(error.response.data)
            })
    }

    handleChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        this.setState({ [name] : value });
    }

    render(){
        const usuarioLogado = LocalStorageService.obterItem('_usuario_logado')
        const tipos = this.service.obterListaTipos();
        const status = this.service.obterListaStatus();
       
        return (
            <Card title={ this.state.atualizando ? 'Atualização de Pessoa'  : 'Cadastro de Pessoa' }>
                <div className="row">
                    <div className="col-md-8">
                        <FormGroup id="inputNome" label="Nome: *" >
                            <input id="inputNome" type="text" 
                                   className="form-control" 
                                   name="nomePessoa"
                                   value={this.state.nomePessoa}
                                   onChange={this.handleChange}  />
                        </FormGroup>
                    </div>
                
                
                    <div className="col-md-4">
                        <FormGroup id="inputDocumento" label="Documento: *">
                            <input id="inputDocumento" type="text"
                                   className="form-control"
                                   name="numeroDocumento"
                                   //value={cpfMask(this.state.numeroDocumento)}
                                   value={this.state.numeroDocumento}
                                   onChange={this.handleChange} />
                        </FormGroup>
                    </div>
                </div>

                <div className="row">    
                    <div className="col-md-4">
                        <FormGroup id="inputTipo" label="Tipo: *">
                            <SelectMenu id="inputTipo" 
                                        className="form-control"
                                        name="tipoPessoa"
                                        value={this.state.tipoPessoa}
                                        onChange={this.handleChange}
                                        lista={tipos} />
                        </FormGroup>
                    </div>
                    
                    <div className="col-md-4">
                         <FormGroup id="inputStatus" label="Status: *">
                            <SelectMenu id="inputStatus" 
                                        lista={status} 
                                        name="statusPessoa"
                                        value={this.state.statusPessoa}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputStatus" label="Email usuário: ">
                            <input type="text" 
                                   className="form-control" 
                                   name="usuarioLogado"
                                   value={usuarioLogado.email}
                                   disabled />
                        </FormGroup>
                    </div>


                </div>    

                <div className="row">  
                     <div className="col-md-6" >
                        { this.state.atualizando ? 
                            (
                                <button onClick={this.atualizar} 
                                        className="btn btn-success">
                                        <i className="pi pi-refresh"></i> Atualizar
                                </button>
                            ) : (
                                <button onClick={this.incluir} 
                                        className="btn btn-success">
                                        <i className="pi pi-save"></i> Salvar
                                </button>
                            )
                        }
                        <button onClick={e => this.props.history.push('/consulta-pessoas')} 
                                className="btn btn-danger">
                                <i className="pi pi-times"></i>Cancelar
                        </button>
                    </div>
                </div>
            </Card>
        )
    }
}

export default withRouter(CadastroPessoas);