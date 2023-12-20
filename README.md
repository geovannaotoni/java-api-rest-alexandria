# 📚 Biblioteca de Alexandria - API REST com Spring Data JPA
Este projeto consiste em uma API Restful desenvolvida com Spring Data JPA para gerenciar uma biblioteca digital. A aplicação utiliza um banco de dados MySQL configurado por meio do docker-compose e inclui tabelas para armazenar informações sobre livros, autores, editoras e relacionamentos entre eles.

## 🛠️ Configuração do Ambiente
Certifique-se de ter o Docker instalado na sua máquina antes de prosseguir.

### 🐳 Docker Compose
O arquivo docker-compose.yaml contém a configuração do serviço do MySQL configurado para armazenar os dados da aplicação.

#### Comandos Docker Compose
1. Subir o ambiente (MySQL):
```bash
docker-compose up -d
```
2. Encerrar o ambiente:
```bash
docker-compose down
```

## 💾 Estrutura do Banco de Dados
A estrutura do banco de dados inclui as seguintes tabelas:
- **books:** Armazena informações sobre os livros (título e gênero).
- **authors:** Mantém dados dos autores (nome e nacionalidade).
- **publishers:** Contém informações das editoras (nome e endereço).
- **author_books:** Tabela de relacionamento N:N entre livros e autores.
- **book_details:** Tabela de relacionamento 1:1 com livros, armazenando detalhes específicos do livro (resumo, contagem de páginas, ano, isbn).
- Relacionamento 1:N entre editora e livros.

## ⚙️ Funcionalidades da API
A API oferece endpoints para realizar operações CRUD (Create, Read, Update, Delete) para cada entidade:
* `/api/books`: Gerencia informações dos livros.
* `/api/authors`: Gerencia informações dos autores.
* `/api/publishers`: Gerencia informações das editoras.

### 🚀 Exemplos de Endpoints
- `GET /books`: Obtém todos os livros cadastrados.
- `GET /books/{id}`: Obtém detalhes de um livro específico.
- `POST /books`: Adiciona um novo livro.
- `PUT /books/{bookId}`: Atualiza informações de um livro.
- `DELETE /books/{bookId}`: Remove um livro.

Consulte a documentação detalhada da API para mais informações sobre os endpoints disponíveis e seus usos.

## 💻 Como Executar o Projeto
1. Clone o repositório.
2. Suba o ambiente com Docker Compose.
3. Execute a aplicação Spring Boot.
4. Utilize ferramentas como Postman, Insomnia ou seu navegador para acessar os endpoints da API.
