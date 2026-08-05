# Sistema de Cursos - JPA, Hibernate e PostgreSQL

## Descrição

Este projeto foi desenvolvido como prática da disciplina de **Programação Web I**, com o objetivo de aplicar os conceitos de **ORM (Object-Relational Mapping)** utilizando **Jakarta Persistence (JPA)** e **Hibernate** como implementação da especificação.

Durante a atividade foi realizada a configuração da camada de persistência, o mapeamento de entidades, a criação de relacionamentos entre elas e a implementação do padrão **DAO (Data Access Object)** para executar operações de CRUD utilizando o `EntityManager`.

O banco de dados utilizado foi o **PostgreSQL**, enquanto o gerenciamento das dependências foi realizado com o **Apache Maven**.

---

## Objetivos da prática

* Configurar um projeto Java utilizando Maven.
* Configurar o Hibernate como implementação da JPA.
* Criar e configurar o arquivo `persistence.xml`.
* Realizar a conexão com um banco de dados PostgreSQL.
* Modelar entidades utilizando anotações da JPA.
* Implementar relacionamentos entre entidades.
* Criar uma camada de acesso a dados (DAO).
* Executar operações de CRUD utilizando o `EntityManager`.
* Realizar consultas utilizando JPQL.

---

## Tecnologias utilizadas

* Java 21
* Jakarta Persistence (JPA)
* Hibernate ORM
* PostgreSQL
* Maven

---

## Estrutura do projeto

```text
src
├── main
│   ├── java
│   │   └── com.daniel
│   │       ├── dao
│   │       ├── db
│   │       ├── entities
│   │       └── Main.java
│   └── resources
│       └── META-INF
│           └── persistence.xml
```

---

## Entidades

O projeto possui três entidades principais:

### Instrutor

Representa o professor responsável pelos cursos.

Principais atributos:

* id
* nome
* email
* biografia

---

### Curso

Representa um curso cadastrado na plataforma.

Principais atributos:

* id
* titulo
* descricao
* cargaHoraria
* preco
* nivel
* status
* url

Relacionamento:

* Um curso pertence a um instrutor.

---

### Aula

Representa uma aula pertencente a um curso.

Principais atributos:

* id
* titulo
* descricao
* ordem
* duracaoMinutos
* urlVideo

Relacionamento:

* Uma aula pertence a um curso.

---

## DAOs implementados

Foram implementados os seguintes DAOs:

* `InstrutorDaoImpl`
* `CursoDaoImpl`
* `AulaDaoImpl`

Cada DAO implementa a interface genérica `GenericDAO`, disponibilizando as operações básicas de persistência:

* salvar()
* buscarPorId()
* buscarTodos()
* atualizar()
* remover()

Além disso, foram implementadas consultas específicas, como:

* `buscarPorNome()`
* `buscarPorTitulo()`
* `buscarPorOrdem()`

---

## Operações testadas

Durante o desenvolvimento foram realizados testes das principais operações da JPA:

* Persistência de entidades (`persist`)
* Atualização (`merge`)
* Busca por ID (`find`)
* Remoção (`remove`)
* Consultas utilizando JPQL
* Gerenciamento de transações
* Relacionamentos entre entidades

---

## Configuração do banco

No arquivo `persistence.xml` foram configurados:

* Driver PostgreSQL
* URL de conexão
* Usuário e senha
* Atualização automática do esquema (`hibernate.hbm2ddl.auto=update`)
* Exibição dos comandos SQL executados pelo Hibernate

---

## Aprendizados

Com esta prática foi possível compreender:

* O funcionamento da especificação JPA;
* A utilização do Hibernate como implementação de ORM;
* O ciclo de vida das entidades;
* O gerenciamento de transações com `EntityTransaction`;
* A utilização do `EntityManager`;
* A escrita de consultas utilizando JPQL;
* A implementação do padrão DAO para separar a lógica de acesso aos dados da lógica de negócio.

---

## Referência

Esta prática foi desenvolvida com base na série de artigos disponibilizada para a disciplina de Programação Web I:

* [Série de artigos sobre ORM/JPA - Programação Web I](https://www.oracle.com/br/technical-resources/articles/dsl/crud-rest-sb2-hibernate.html?utm_source=chatgpt.com)

Os artigos apresentam a configuração do ambiente, o mapeamento de entidades, relacionamentos, utilização do `EntityManager`, implementação de DAOs e operações de persistência utilizando JPA e Hibernate.


## Observações

Durante o desenvolvimento deste projeto, também foram utilizadas ferramentas de Inteligência Artificial como apoio para esclarecimento de dúvidas, compreensão de conceitos, identificação e correção de erros, sempre em conjunto com o material de referência e os testes realizados durante a implementação.
