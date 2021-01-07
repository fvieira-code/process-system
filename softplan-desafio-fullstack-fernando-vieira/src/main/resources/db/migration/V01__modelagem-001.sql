CREATE TABLE usuario
(
    id bigint auto_increment PRIMARY KEY,
    nome character varying(150),
    email character varying(100),
    senha character varying(20),
    data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE lancamento
(
    id bigint auto_increment PRIMARY KEY ,
    descricao character varying(100) NOT NULL,
    mes integer NOT NULL,
    ano integer NOT NULL,
    valor numeric(16,2),
    tipo character varying(20),
    status character varying(20),
    id_usuario bigint REFERENCES usuario (id),
    data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE pessoa (
    id      bigint auto_increment PRIMARY KEY ,
    nomepes         VARCHAR(100) NOT NULL,
    cpfcnpjpes      VARCHAR(20) NOT NULL,
    tipopes         VARCHAR(15) NOT NULL,
    statuspes       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE assunto (
	codigoass       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricaoass    VARCHAR(100) NOT NULL,
    statusass       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO assunto (descricaoass, statusass, codigousu, codigocid) values ('DIREITO CIVIL, NÃO INFORMADO', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO assunto (descricaoass, statusass, codigousu, codigocid) values ('DIREITO COMERCIAL, NÃO INFORMADO', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE instituicao (
	codigoins       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricaoins    VARCHAR(100) NOT NULL,
    statusins       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO instituicao (descricaoins, statusins, codigousu, codigocid) values ('BANCO DO BRASIL S.A.', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO instituicao (descricaoins, statusins, codigousu, codigocid) values ('GOVERNO DO ESTADO DE SANTA CATARINA', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE competencia (
	codigocom       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricaocom    VARCHAR(100) NOT NULL,
    statuscom       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO competencia (descricaocom, statuscom, codigousu, codigocid) values ('CIVEL E COMERCIO - ASSISTENCIA', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO competencia (descricaocom, statuscom, codigousu, codigocid) values ('CIVEL E COMERCIO - OUVIDORIA', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE classe (
	codigocla       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricaocla    VARCHAR(100) NOT NULL,
    statuscla       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO classe (descricaocla, statuscla,  codigousu, codigocid) values ('MONITÓRIA', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO classe (descricaocla, statuscla,  codigousu, codigocid) values ('OUVIDORIA', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE gabinete (
	codigogab       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricaogab    VARCHAR(100) NOT NULL,
    statusgab       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO gabinete (descricaogab, codigousu, statusgab, codigocid) values ('GABINETE DA 13a VARA CÍVEL E EMPRESARIAL DE BELÉM', 'fvieira',  'ATIVO', 'SOLICITACAO_USUARIO');
INSERT INTO gabinete (descricaogab, codigousu, statusgab, codigocid) values ('GABINETE DA 10a VARA CÍVEL E EMPRESARIAL DE FLORIANÓPOLIS', 'fvieira',  'ATIVO', 'SOLICITACAO_USUARIO');

CREATE TABLE secretaria (
	codigosec       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricaosec    VARCHAR(100) NOT NULL,
    statussec       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO secretaria (descricaosec, statussec, codigousu, codigocid) values ('SECRETARIA DA 13a VARA CÍVEL E EMPRESARIAL DE BELÉM', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO secretaria (descricaosec, statussec, codigousu, codigocid) values ('SECRETARIA DA 10a VARA CÍVEL E EMPRESARIAL DE FLORIANÓPOLIS', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE magistrado (
	codigomag       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigopes       BIGINT(20) NOT NULL,
	descricaomag    VARCHAR(100) NOT NULL,
    statusmag       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO magistrado (codigopes, descricaomag, statusmag, codigousu, codigocid) values (3, 'JUIZ DA 1a INSTANCIA', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO magistrado (codigopes, descricaomag, statusmag, codigousu, codigocid) values (3, 'JUIZ DA 2a INSTANCIA', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE vara (
	codigovar       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricaovar    VARCHAR(100) NOT NULL,
    statusvar       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO vara (descricaovar, statusvar, codigousu, codigocid) values ('13a VARA CÍVEL E EMPRESARIAL DE BELÉM', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO vara (descricaovar, statusvar, codigousu, codigocid) values ('10a VARA CÍVEL E EMPRESARIAL DE FLORIANÓPOLIS', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE area (
	codigoare       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricaoare    VARCHAR(100) NOT NULL,
    statusare       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO area (descricaoare, statusare, codigousu, codigocid) values ('CÍVEL', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO area (descricaoare, statusare, codigousu, codigocid) values ('EMPRESARIAL', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO area (descricaoare, statusare, codigousu, codigocid) values ('FAMILIAR', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE instancia (
	codigoint       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricaoint    VARCHAR(100) NOT NULL,
    statusint       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO instancia (descricaoint, statusint, codigousu, codigocid) values ('1o GRAU', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO instancia (descricaoint, statusint, codigousu, codigocid) values ('2o GRAU', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE comarca (
    codigocmc       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricaocmc    VARCHAR(100),
    ufcmc           VARCHAR(2),
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO comarca (descricaocmc, ufcmc, codigousu, codigocid ) values ('BELEM', 'PA', 1, 'SOLICITACAO_USUARIO');
INSERT INTO comarca (descricaocmc, ufcmc, codigousu, codigocid ) values ('FLORIANOPOLIS', 'SC', 1, 'SOLICITACAO_USUARIO');

CREATE TABLE situacao (
	codigosit       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricaosit    VARCHAR(100) NOT NULL,
    statussit       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO situacao (descricaosit, statussit, codigousu, codigocid) values ('EM ANDAMENTO', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO situacao (descricaosit, statussit, codigousu, codigocid) values ('ARQUIVADO', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO situacao (descricaosit, statussit, codigousu, codigocid) values ('ENCERRADO', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE processo (
	codigopro       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigocnj       VARCHAR(35),
	codigosit       BIGINT(20),
	numeroinqpol    VARCHAR(50),
	statuspro       VARCHAR(15),
    datadistpro     DATETIME,
    valorpro        NUMERIC(16,2),
    dataautupro     DATETIME,
    segredopro      VARCHAR(15),
    volumepro       INTEGER,
    paginapro       INTEGER,
    prioridadepro   VARCHAR(15),
    gratuidadepro   VARCHAR(15),
    fundamentopro   TEXT,
    codigoint       BIGINT(20),
    codigocmc       BIGINT(20),
    codigoare       BIGINT(20),
    codigovar       BIGINT(20),
    codigogab       BIGINT(20),
    codigosec       BIGINT(20),
    codigomag       BIGINT(20),
    codigocom       BIGINT(20),
    codigocla       BIGINT(20),
    codigoass       BIGINT(20),
    codigoins       BIGINT(20),
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE movimentacao (
	codigomov       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigopro       BIGINT(20) NOT NULL,
	datamov         DATETIME NOT NULL,
	descricaomov    VARCHAR(100) NOT NULL,
    statusmov       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO movimentacao (codigopro, datamov, descricaomov, statusmov, codigousu, codigocid) values (1, sysdate(), 'ANALISE DE DOCUMENTOS', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO movimentacao (codigopro, datamov, descricaomov, statusmov, codigousu, codigocid) values (1, sysdate(), 'INCLUSÃO DE DOCUMENTOS', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE partes (
	codigopar       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigopes       BIGINT(20) NOT NULL,
	codigopro       BIGINT(20) NOT NULL,
	descricaopar    VARCHAR(100) NOT NULL,
    statuspar       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO partes (codigopes, codigopro, descricaopar, statuspar, codigousu, codigocid) values (1, 1, 'AUTOR', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO partes (codigopes, codigopro, descricaopar, statuspar, codigousu, codigocid) values (4, 1, 'ADVOGADO', 'ATIVO','fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO partes (codigopes, codigopro, descricaopar, statuspar, codigousu, codigocid) values (5, 1, 'ADVOGADO', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO partes (codigopes, codigopro, descricaopar, statuspar, codigousu, codigocid) values (6, 1, 'REU', 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE causa (
	codigocau       BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigopro       BIGINT(20) NOT NULL,
	datacau         DATETIME NOT NULL,
	valorcau        NUMERIC(10,2) NOT NULL,
    statuscau       VARCHAR(15) NOT NULL,
    codigousu       VARCHAR(255) NOT NULL,
    codigocid       VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO causa (codigopro, datacau, valorcau, statuscau, codigousu, codigocid) values (1, sysdate(), 9000.00, 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');
INSERT INTO causa (codigopro, datacau, valorcau, statuscau, codigousu, codigocid) values (1, sysdate(), 10000.00, 'ATIVO', 'fvieira', 'SOLICITACAO_USUARIO');

CREATE TABLE controlemensagem (
    codigouid       VARCHAR(255)  PRIMARY KEY,
    codigousu       VARCHAR(255)  NOT NULL,
    codigocid       VARCHAR(255)  NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO controlemensagem (codigouid, codigousu, codigocid) values ('softplandesafio2020','fvieira', 'SOLICITACAO_USUARIO');

