-- create the databases
CREATE DATABASE IF NOT EXISTS db-softplan-desafio-fullstack-001;

-- create the users for each database
CREATE USER 'root'@'%' IDENTIFIED BY 'luiz05012013';
GRANT CREATE, ALTER, INDEX, LOCK TABLES, REFERENCES, UPDATE, DELETE, DROP, SELECT, INSERT ON 'db-softplan-desafio-fullstack-001'.* TO 'root'@'%';

FLUSH PRIVILEGES;
