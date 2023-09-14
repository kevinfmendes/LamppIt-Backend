# LamppIt-Backend - Kevin Mendes
Projeto desenvolvido como parte do processo para vaga de Desenvolvedor FullStack Jr. da LamppIt.

## Backend Java
Este projeto é parte do teste técnico para a vaga de Desenvolvedor FullStack Jr na empresa LamppIt. Ele consiste em um backend desenvolvido em Java com Spring Boot e Spring Data JPA, fornecendo endpoints RESTful para operações CRUD na classe Cliente. O banco de dados utilizado é o MySQL, e o controle de migração é gerenciado pelo Flyway.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3 
- Spring Data JPA
- MySQL 8.0 
- Flyway (migrações do banco de dados)
- Apache Maven (gerenciador de projetos e dependências)

## Funcionalidades
- Cadastro de novo cliente
- Listagem de clientes cadastrados
- Atualizar/Editar cadastro de cliente por id
- Exclusão de cadastro de cliente por id

*Endpoints / URL's*
 
|  URL |  Método | Descrição |
|----------|--------------|--------------|
|`http://localhost:8080/lamppit/salvar-cliente`                                 | POST | Salva o cliente no banco de dados |
|`http://localhost:8080/lamppit/listar-todos`                                 | GET | Lista todos os cadastros de clientes presentes no banco de dados |
|`http://localhost:8080/lamppit/buscar-por-id?id=`                             | GET | Busca de cliente baseado no Id salvo no banco de dados |
|`http://localhost:8080/lamppit/atualizar-cliente`                             | PUT | Edição de cliente salvo no banco de dados |
|`http://localhost:8080/lamppit/excluir-por-id?id=`                               | DELETE | Deleta cadastro do cliente |


