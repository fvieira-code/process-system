# Utilizando Java 8
FROM openjdk:8-jdk-alpine

#Autor do volume
MAINTAINER Fernando Vieira - backend

#Variavel volume
ENV VOLUME=/fvieira-code/backend
 
# Nome do pacote gerado pelo Maven
ARG JAR_FILE=target/softplan-backend-0.0.1-SNAPSHOT.jar
 
# Altera internamente para o diretório VOLUME
WORKDIR ${VOLUME}
 
# Copia a aplicação com um nome diferente para WORKDIR 
COPY ${JAR_FILE} backend.jar
 
# Executa o comando java -jar /VOLUME/backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]
