# PROCESSO Service

## O projeto foi criado e está gerenciado no JIRA, seguindo a metodologia Ágil utilizando o gerenciamento SCRUM.

## Ferramentas de Desenvolvimento
Controle de versão utilizado no projeto é o [GitHub](hhttps://github.com/), especificamente o 
[GitHub de Fernando vieira](https://https://github.com/fvieira-code?tab=repositories).

1.	Projeto montado com o Spring-Boot versão 2.3.3 e Maven 3.6.3;
O projeto foi criado, basicamente com o [Java 8](https://www.oracle.com/java/technologies/java8.html), usando [Spring Framework](https://spring.io/projects/spring-framework) e o [Maven](https://maven.apache.org/) como controle de dependências.

2.O projeto está utilizando o [Lombok](https://projectlombok.org), portanto será necessário fazer a instalação do plugin do Lombok na IDE que esteja trabalhando, seja o [Eclipse](https://projectlombok.org/setup/eclipse), seja o [IntelliJ IDEA](https://projectlombok.org/setup/intellij) ou [MS Visual Studio Code](https://projectlombok.org/setup/vscode).	

3. O ambiente doi montado usando o [Docker](https://www.docker.com) e o [docker-compose](https://docs.docker.com/compose) instalado no seu computador.

Após a instalação do Docker e docker-compose, é necesário abrir o terminal do SO e navegar até a pasta do projeto, e entrar na pasta _docker_, dentro dessa mesma existem os arquivos __docker-compose.yaml__e setup-0011.sql, que possui as imagens do [MySql](https://https://dev.mysql.com/) 

Para executar o arquivo docker-compose, basta executar o seguinte código no terminal na pasta __docker__ que existe no projeto.
> docker-compose up

4. Frameworks:

## Executar FlywayDB
Para executar os scripts e montar a estrutura de dados no banco selecionado, deve-se executar o seguinte comando maven no terminal na raiz do projeto:
> mvn flyway:migrate -Dflyway.user=root -Dflyway.password=luiz05012013 -Dflyway.url=jdbc:mysql://localhost:3306/db-softplan-desafio-fullstack-001

## Controle FlywayDB
Todos os scripts necessários para que esse projeto funcione, devem ser adicionados na pasta _resources/db/migration_, seguindo a sugestão do [FlywayDB Discovery](https://flywaydb.org/documentation/migrations#discovery), seguindo o seguinte [padrão do FlywayDB](https://flywaydb.org/documentation/migrations#naming).

Vale salientar a importância de criar os scripts SQL usando somente SQL ANSI, visando garantir a compatibilidade com qualquer banco de dados ou diminuir o esforço de migrar de banco de dados.


5. Swagger-UI
Acessar a documentação online do projeto, será necessário iniciar o projeto então a documentação estará disponível em:
>http://localhost:8090/processo/swagger-ui.html

Nesta pagina pade ser consumir todos os serviços, mas também pode se usar outras ferramentas como Postman (www.getpostman.com ) , SoapUI (www.soapui.org) e outras.

##Evoluções 
## Front-end 
React é uma biblioteca JavaScript de código aberto com foco em criar interfaces de usuário em páginas web.

## Autenticação
O sistema terá autenticação usando [Spring Security](https://spring.io/projects/spring-security) com o [Keycloak](https://www.keycloak.org/). 
