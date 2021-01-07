import React from 'react'
import Card from '../../components/card'
import FormGroup from '../../components/form-group'
import SelectMenu from '../../components/selectMenu'
import { withRouter } from 'react-router-dom'
import * as messages from '../../components/toastr'
import ProcessoService from '../../app/service/processoService'
import LocalStorageService from '../../app/service/localstorageService'
import SelectMenuInstancia from '../../components/selectMenuInstancia'
import SelectMenuComarca from '../../components/selectMenuComarca'
import SelectMenuSituacao from '../../components/selectMenuSituacao'
import SelectMenuArea from '../../components/selectMenuArea'
import SelectMenuVara from '../../components/selectMenuVara'
import SelectMenuGabinete from '../../components/selectMenuGabinete'
import SelectMenuSecretaria from '../../components/selectMenuSecretaria'
import SelectMenuMagistrado from '../../components/selectMenuMagistrado'
import SelectMenuCompetencia from '../../components/selectMenuCompetencia'
import SelectMenuClasse from '../../components/selectMenuClasse'
import SelectMenuAssunto from '../../components/selectMenuAssunto'
import SelectMenuInstituicao from '../../components/selectMenuInstituicao'
import { processoMask } from './mask-processo'
import { Calendar } from 'primereact/calendar'
import { InputNumber } from 'primereact/inputnumber'
import { InputTextarea } from 'primereact/inputtextarea'

class CadastroProcessos extends React.Component {

    state = {
        atualizando: false,
        numeroProcesso: '',
        idInstancia: '',
        idComarca: '',
        idSituacao: '',
        idArea: '',
        datadistribuicaoProcesso: '',
        idVara: '',
        idGabinete: '',
        idSecretaria: '',
        idMagistrado: '',
        idCompetencia: '',
        idClasse: '', 
        idAssunto: '',
        idInstituicao: '',
        numeroInqueritoPolicialProcesso: '',
        valorCausaProcesso: '',
        statusProcesso: '',
        dataAutuacaoProcesso: '',
        segredoJusticaProcesso: '',
        volumeProcesso: '',
        numeroPaginaProcesso: '',
        prioridadeProcesso: '', 
        gratuidadeProcesso: '', 
        fundamentacaoProcesso: '',
        idAutor: '',
        idAdvogado: '',
        idReu: '',
        correlationId: '',
        codigoUsuario: '',
        
        instanciaProcesso: [],
        comarcaProcesso: [],
        situacaoProcesso: [],
        areaProcesso: [],
        varaProcesso: [],
        gabineteProcesso: [],
        secretariaProcesso: [],
        magistradoProcesso: [],
        competenciaProcesso: [],
        classeProcesso: [],
        assuntoProcesso: [],
        instituicaoProcesso: []

    }

    constructor(){
        super();
        this.service = new ProcessoService();
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

        this.service.obterListaInstancia().then(response => {
            this.setState({ instanciaProcesso: response.data });
        });            
        this.service.obterListaComarca().then(response => {
            this.setState({ comarcaProcesso: response.data });
        });
        this.service.obterListaSituacao().then(response => {
            this.setState({ situacaoProcesso: response.data });
        });  
        this.service.obterListaArea().then(response => {
            this.setState({ areaProcesso: response.data });
        });
        this.service.obterListaVara().then(response => {
            this.setState({ varaProcesso: response.data });
        });
        this.service.obterListaGabinete().then(response => {
            this.setState({ gabineteProcesso: response.data });
        });
        this.service.obterListaSecretaria().then(response => {
            this.setState({ secretariaProcesso: response.data });
        });
        this.service.obterListaMagistrado().then(response => {
            this.setState({ magistradoProcesso: response.data });
        });
        this.service.obterListaCompetencia().then(response => {
            this.setState({ competenciaProcesso: response.data });
        });
        this.service.obterListaClasse().then(response => {
            this.setState({ classeProcesso: response.data });
        });
        this.service.obterListaAssunto().then(response => {
            this.setState({ assuntoProcesso: response.data });
        });
        this.service.obterListaInstituicao().then(response => {
            this.setState({ instituicaoProcesso: response.data });
        });
              
    }

    incluir = () => {
        const usuarioLogado = LocalStorageService.obterItem('_usuario_logado')
        const {idInstancia} = this.state;
        const codigoInstancia = {id: idInstancia};
        const {idComarca} = this.state;
        const codigoComarca = {id: idComarca};
        const {idSituacao} = this.state;
        const codigoSituacao = {id: idSituacao};
        const {idArea} = this.state;
        const codigoArea = {id: idArea};
        const {idVara} = this.state;
        const codigoVara = {id: idVara};
        const {idGabinete} = this.state;
        const codigoGabinete = {id: idGabinete};
        const {idSecretaria} = this.state;
        const codigoSecretaria = {id: idSecretaria};
        const {idMagistrado} = this.state;
        const codigoMagistrado = {id: idMagistrado};
        const {idCompetencia} = this.state;
        const codigoCompetencia = {id: idCompetencia};
        const {idClasse} = this.state;
        const codigoClasse = {id: idClasse};
        const {idAssunto} = this.state;
        const codigoAssunto = {id: idAssunto};
        const {idInstituicao} = this.state;
        const codigoInstituicao = {id: idInstituicao};

        const { numeroProcesso, datadistribuicaoProcesso, numeroInqueritoPolicialProcesso, valorCausaProcesso, dataAutuacaoProcesso,
            segredoJusticaProcesso, volumeProcesso, numeroPaginaProcesso, prioridadeProcesso, gratuidadeProcesso, fundamentacaoProcesso} = this.state;
            const processos = { numeroProcesso, datadistribuicaoProcesso, numeroInqueritoPolicialProcesso, valorCausaProcesso, statusProcesso: 'ATIVO',
                dataAutuacaoProcesso, segredoJusticaProcesso, volumeProcesso, numeroPaginaProcesso, prioridadeProcesso, gratuidadeProcesso, 
                fundamentacaoProcesso, codigoInstancia, codigoComarca, codigoSituacao, codigoArea, codigoVara, codigoGabinete, codigoSecretaria, 
                codigoMagistrado, codigoCompetencia, codigoClasse, codigoAssunto, codigoInstituicao, codigoUsuario: usuarioLogado.id, 
                correlationId: 'SOLICITACAO_INCLUSAO'};

        try{
            this.service.validar(processos)
        }catch(erro){
            const mensagens = erro.mensagens;
            mensagens.forEach(msg => messages.mensagemErro(msg));
            return false;
        }     

        this.service
            .incluirProcesso(processos)
            .then(response => {
                this.props.history.push('/consulta-processos')
                messages.mensagemSucesso('Processo cadastrado com sucesso!')
            }).catch(error => {
                messages.mensagemErro(error.response.data)
            })
    }

    atualizar = () => {
        const usuarioLogado = LocalStorageService.obterItem('_usuario_logado')
        
        const { id, numeroProcesso, codigoSituacao, statusProcesso } = this.state;
        const processos = { id, numeroProcesso, codigoSituacao, statusProcesso, codigoUsuario: usuarioLogado.id, correlationId: 'SOLICITACAO_INCLUSAO'};
        
        this.service
            .alterarProcesso(processos)
            .then(response => {
                this.props.history.push('/consulta-processos')
                messages.mensagemSucesso('Processo atualizado com sucesso!')
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
        const status = this.service.obterListaStatus();
        const boolean = this.service.obterListaBoolean();

        const br = {
            firstDayOfWeek: 1,
            dayNames: ["domingo", "segunda", "terça", "quart", "quinta", "sext", "sábado"],
            dayNamesShort: ["dom", "seg", "ter", "qua", "qui", "sex", "sáb"],
            dayNamesMin: ["D", "S", "T", "Q", "Q", "S", "S"],
            monthNames: ["janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "ou0tubro", "novembro", "dezembro"],
            monthNamesShort: ["ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"],
            today: "Hoje",
            clear: "Limpar"
        };

        return (
            <Card title={ this.state.atualizando ? 'Atualização de Processo'  : 'Cadastro de Processo' }>
                <div className="row">
                    <div className="col-md-8">
                        <FormGroup id="inputNumeroProcesso" label="Número do Processo: *" >
                            <input id="inputNumeroProcesso" type="text" 
                                   className="form-control" 
                                   name="numeroProcesso"
                                   value={processoMask(this.state.numeroProcesso)}
                                   onChange={this.handleChange}  />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputStatusProcesso" label="Status do Processo: *">
                            <SelectMenu id="inputStatusProcesso" 
                                        lista={status} 
                                        name="statusProcesso"
                                        value={this.state.statusProcesso}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>
                </div>

                <div className="row">    
                    <div className="col-md-4">
                         <FormGroup id="inputInstancia" label="Instância: *">
                            <SelectMenuInstancia id="inputInstancia" 
                                        lista={this.state.instanciaProcesso} 
                                        name="idInstancia"
                                        value={this.state.idInstancia}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputComarca" label="Comarca: *">
                            <SelectMenuComarca id="inputComarca" 
                                        lista={this.state.comarcaProcesso} 
                                        name="idComarca"
                                        value={this.state.idComarca}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputSituacao" label="Situação: *">
                            <SelectMenuSituacao id="inputSituacao" 
                                        lista={this.state.situacaoProcesso} 
                                        name="idSituacao"
                                        value={this.state.idSituacao}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>
                </div>

                <div className="row">    
                    <div className="col-md-4">
                         <FormGroup id="inputArea" label="Area: *">
                            <SelectMenuArea id="inputArea" 
                                        lista={this.state.areaProcesso} 
                                        name="idArea"
                                        value={this.state.idArea}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                        <FormGroup id="inputDataDistribuicao" label="Data da Distribuição: *">
                            <Calendar id="inputDataDistribuicao" 
                                    value={this.state.datadistribuicaoProcesso} onChange={(e) => this.setState({ datadistribuicaoProcesso: e.value })} 
                                    showIcon locale={br} dateFormat="dd/mm/yy" />
                        </FormGroup>
                    </div>
                    
                    <div className="col-md-4">
                         <FormGroup id="inputVara" label="Vara/Câmara: *">
                            <SelectMenuVara id="inputVara" 
                                        lista={this.state.varaProcesso} 
                                        name="idVara"
                                        value={this.state.idVara}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>
                </div>    

                <div className="row">
                    <div className="col-md-4">
                         <FormGroup id="inputGabinete" label="Gabinete: *">
                            <SelectMenuGabinete id="inputGabinete" 
                                        lista={this.state.gabineteProcesso} 
                                        name="idGabinete"
                                        value={this.state.idGabinete}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputSecretaria" label="Secretaria: *">
                            <SelectMenuSecretaria id="inputSecretaria" 
                                        lista={this.state.secretariaProcesso} 
                                        name="idSecretaria"
                                        value={this.state.idSecretaria}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputMagistrado" label="Magistrado: *">
                            <SelectMenuMagistrado id="inputMagistrado" 
                                        lista={this.state.magistradoProcesso} 
                                        name="idMagistrado"
                                        value={this.state.idMagistrado}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>
                </div>    

                <div className="row">
                    <div className="col-md-4">
                         <FormGroup id="inputCompetencia" label="Competência: *">
                            <SelectMenuCompetencia id="inputCompetencia" 
                                        lista={this.state.competenciaProcesso} 
                                        name="idCompetencia"
                                        value={this.state.idCompetencia}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputClasse" label="Classe: *">
                            <SelectMenuClasse id="inputClasse" 
                                        lista={this.state.classeProcesso} 
                                        name="idClasse"
                                        value={this.state.idClasse}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputAssunto" label="Assunto: *">
                            <SelectMenuAssunto id="inputAssunto" 
                                        lista={this.state.assuntoProcesso} 
                                        name="idAssunto"
                                        value={this.state.idAssunto}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>
                </div>    

                <div className="row">
                    <div className="col-md-4">
                         <FormGroup id="inputInstituicao" label="Instituição: *">
                            <SelectMenuInstituicao id="inputInstituicao" 
                                        lista={this.state.instituicaoProcesso} 
                                        name="idInstituicao"
                                        value={this.state.idInstituicao}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-8">
                        <FormGroup id="inputNumeroInqueritoProcesso" label="Número do Inquérito Policial: *" >
                            <input id="inputNumeroInqueritoProcesso" type="text" 
                                   className="form-control" 
                                   name="numeroInqueritoPolicialProcesso"
                                   value={this.state.numeroInqueritoPolicialProcesso}
                                   onChange={this.handleChange}  />
                        </FormGroup>
                    </div>
                </div>    
                
                <div className="row">

                <div className="col-md-4">
                        <FormGroup id="inputDataAutuacao" label="Data da Autuação: *">
                                <Calendar id="inputDataAutuacao" 
                                        value={this.state.dataAutuacaoProcesso} onChange={(e) => this.setState({ dataAutuacaoProcesso: e.value })} 
                                        showIcon locale={br} dateFormat="dd/mm/yy" />
                        </FormGroup>
                    </div>
                    
                    <div className="col-md-4">
                         <FormGroup id="inputSegredoProcesso" label="Segredo de Justiça: *">
                            <SelectMenu id="inputSegredoProcesso" 
                                        lista={boolean} 
                                        name="segredoJusticaProcesso"
                                        value={this.state.segredoJusticaProcesso}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputPrioridadeProcesso" label="Prioridade: *">
                            <SelectMenu id="inputPrioridadeProcesso" 
                                        lista={boolean} 
                                        name="prioridadeProcesso"
                                        value={this.state.prioriadeProcesso}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>
                </div>    

                <div className="row">

                    <div className="col-md-4">
                        <FormGroup id="inputValorProcesso" >
                            <label htmlFor="locale-user">Valor da Causa do Processo: *</label>
                            <InputNumber id="valorCausaProcesso" value={this.state.valorCausaProcesso} onValueChange={(e) => this.setState({valorCausaProcesso: e.value})} mode="decimal" minFractionDigits={2} />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputVolumeProcesso" label="Volume do Processo: *">
                            <label htmlFor="integeronly"></label>
                            <InputNumber id="inputVolumeProcesso" value={this.state.volumeProcesso} onValueChange={(e) => this.setState({volumeProcesso: e.value})} />   
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                        <FormGroup id="inputNumeroPaginaProcesso" label="Número de Páginas: *">
                            <label htmlFor="integeronly"></label>
                            <InputNumber id="inputNumeroPagina" value={this.state.numeroPaginaProcesso} onValueChange={(e) => this.setState({numeroPaginaProcesso: e.value})} />
                        </FormGroup>
                    </div>
                </div>    

                <div className="row">
                    <div className="col-md-4">
                         <FormGroup id="inputGratuidadeProcesso" label="Gratuidade: *">
                            <SelectMenu id="inputGratuidadeProcesso" 
                                        lista={boolean} 
                                        name="gratuidadeProcesso"
                                        value={this.state.gratuidadeProcesso}
                                        onChange={this.handleChange}
                                        className="form-control" />
                        </FormGroup>
                    </div>

                    <div className="col-md-4">
                         <FormGroup id="inputUsuario" label="Nome usuário: ">
                            <input type="text" 
                                   className="form-control" 
                                   name="usuarioLogado"
                                   value={usuarioLogado.nome}
                                   disabled />
                        </FormGroup>
                    </div>

                   <div className="col-md-4">
                         <FormGroup id="inputUsuario" label="Email usuário: ">
                            <input type="text" 
                                   className="form-control" 
                                   name="usuarioLogado"
                                   value={usuarioLogado.email}
                                   disabled />
                        </FormGroup>
                    </div>
                </div>

                <div className="row">
                    <div className="col-md-12">
                        <FormGroup id="inputFundamento" label="Fundamentos do Processo: ">
                            <InputTextarea value={this.state.fundamentacaoProcesso} onChange={(e) => this.setState({fundamentacaoProcesso: e.target.value})} 
                            rows={5} cols={115} />
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
                        <button onClick={e => this.props.history.push('/consulta-processos')} 
                                className="btn btn-danger">
                                <i className="pi pi-times"></i>Cancelar
                        </button>
                    </div>
                </div>
            </Card>
        )
    }
}

export default withRouter(CadastroProcessos);