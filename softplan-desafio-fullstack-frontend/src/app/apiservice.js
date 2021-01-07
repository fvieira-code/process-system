import axios from 'axios'

export const httpClient = axios.create({
    //baseURL: 'https://minhasfinancas-api.herokuapp.com/'
    //baseURL: 'http://localhost:8080'
    baseURL: 'http://localhost:8090/processo/api/v1/',
    //timeout: 100000,
    headers: {'X-Correlation-Id': 'SOLICITACAO_USUARIO'}
})

class ApiService {

    constructor(apiurl){
        this.apiurl = apiurl;
    }

    post(url, objeto){
        const requestUrl = `${this.apiurl}${url}`
        return httpClient.post(requestUrl, objeto);
    }

    put(url, objeto){
        const requestUrl = `${this.apiurl}${url}`
        return httpClient.put(requestUrl, objeto);
    }

    get(url){
        const requestUrl = `${this.apiurl}${url}`
        return httpClient.get(requestUrl)
    }
}

export default ApiService;