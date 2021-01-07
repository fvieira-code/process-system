import React from 'react'

import UsuarioService from '../app/service/usuarioService'
import { AuthContext } from '../main/provedorAutenticacao'

class Home extends React.Component{

    state = {
        saldo: 0
    }

    constructor(){
        super()
        this.usuarioService = new UsuarioService();
    }

    componentDidMount(){
        const usuarioLogado = this.context.usuarioAutenticado

        this.usuarioService
            .obterSaldoPorUsuario(usuarioLogado.id)
            .then( response => {
                this.setState({ saldo: response.data})
            }).catch(error => {
                console.error(error.response)
            });
    }

    render(){
        return (
            <div className="jumbotron">
                <h1 className="display-3">Bem vindo!</h1>
                <p className="lead">Esse é seu sistema de gerenciamento de processos.</p>
                
                <hr className="my-4" />
                <p>E essa é sua área administrativa, utilize um dos emails para entrar em contato.</p>
                
            </div>
        )
    }
}

Home.contextType = AuthContext;

export default Home