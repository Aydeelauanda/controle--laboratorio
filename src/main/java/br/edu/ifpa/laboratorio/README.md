# Sistema de Controle de Empréstimo de Equipamentos

## Integrantes

- Aydêe Lauanda Costa Barroso

---

## Descrição do problema

O sistema foi desenvolvido para realizar o controle de empréstimos de equipamentos de um laboratório acadêmico.  
O projeto permite cadastrar alunos, cadastrar equipamentos, realizar empréstimos, bloquear equipamentos indisponíveis e registrar devoluções.

O objetivo é facilitar o gerenciamento dos equipamentos e evitar conflitos durante os empréstimos.

---

## Tecnologias utilizadas

- Java
- MySQL
- JDBC
- IntelliJ IDEA
- Maven

---

## Estrutura do projeto

- `model` → classes do sistema
- `dao` → acesso ao banco de dados
- `database` → conexão com MySQL
- `README.md` → documentação do projeto

---

## Requisitos implementados

- Cadastro de alunos
- Cadastro de equipamentos
- Listagem de equipamentos disponíveis
- Realização de empréstimos
- Bloqueio de equipamentos indisponíveis
- Registro de devolução
- Histórico de empréstimos

---

## Modelo do banco de dados

### Tabela aluno

| Campo | Tipo |
|---|---|
| id | INT |
| nome | VARCHAR |
| matricula | VARCHAR |

### Tabela equipamento

| Campo | Tipo |
|---|---|
| id | INT |
| nome | VARCHAR |
| disponivel | BOOLEAN |

### Tabela emprestimo

| Campo | Tipo |
|---|---|
| id | INT |
| aluno_id | INT |
| equipamento_id | INT |
| data_emprestimo | DATE |
| data_devolucao | DATE |
| status | VARCHAR |

---

## Diagramas UML

### Diagrama de Classe

![Diagrama de Classe](src/main/java/br/edu/ifpa/laboratorio/images/Diagrama%20de%20classe.png)

---

### Diagrama de Sequência

![Diagrama de Sequência](src/main/java/br/edu/ifpa/laboratorio/images/Diagrama%20de%20sequência.png)

---

### Diagrama de Uso

![Diagrama de Uso](src/main/java/br/edu/ifpa/laboratorio/images/diagramas%20de%20uso.png)

---

## Como criar o banco MySQL

```sql
CREATE DATABASE laboratorio;

USE laboratorio;

CREATE TABLE aluno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    matricula VARCHAR(20)
);

CREATE TABLE equipamento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    disponivel BOOLEAN
);

CREATE TABLE emprestimo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    aluno_id INT,
    equipamento_id INT,
    data_emprestimo DATE,
    data_devolucao DATE,
    status VARCHAR(30),

    FOREIGN KEY (aluno_id) REFERENCES aluno(id),
    FOREIGN KEY (equipamento_id) REFERENCES equipamento(id)
);
