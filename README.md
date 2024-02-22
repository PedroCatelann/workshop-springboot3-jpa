# WorkShop API

Bem-vindo à API de Venda de Produtos! Esta API foi desenvolvida em Spring Boot para facilitar a gestão de vendas, produtos e clientes. A seguir, você encontrará informações sobre as funcionalidades, configurações, endpoints disponíveis e como contribuir para o desenvolvimento.

## Funcionalidades

1. **Produtos:**
   - Listar todos os produtos disponíveis
   - Obter detalhes de um produto específico
   - Adicionar um novo produto ao inventário
   - Atualizar informações de um produto existente
   - Remover um produto do inventário

2. **Clientes:**
   - Listar todos os clientes
   - Obter detalhes de um cliente específico
   - Adicionar um novo cliente
   - Atualizar informações de um cliente existente
   - Remover um cliente

3. **Vendas:**
   - Registrar uma nova venda
   - Obter detalhes de uma venda específica
   - Listar todas as vendas
   - Atualizar informações de uma venda existente
   - Remover uma venda

## Configuração

1. **Banco de Dados:**
   - Configure as propriedades do banco de dados no arquivo `application.properties`

2. **Autenticação:**
   - Configure as propriedades de autenticação no arquivo `application.properties`
   - Defina uma chave secreta para JWT

## Endpoints

1. **Produtos:**
   - `GET /products`: Obter todos os produtos
   - `GET /products/{id}`: Obter detalhes de um produto específico
   - `POST /products`: Adicionar um novo produto
   - `PUT /products/{id}`: Atualizar informações de um produto
   - `DELETE /products/{id}`: Remover um produto

2. **Clientes:**
   - `GET /users`: Obter todos os clientes
   - `GET /users/{id}`: Obter detalhes de um cliente específico
   - `POST /users`: Adicionar um novo cliente
   - `PUT /users/{id}`: Atualizar informações de um cliente
   - `DELETE /users/{id}`: Remover um cliente

3. **Vendas:**
   - `GET /orders`: Obter todas as vendas
   - `GET /orders/{id}`: Obter detalhes de uma venda específica
   - `POST /orders`: Registrar uma nova venda
   - `PUT /orders/{id}`: Atualizar informações de uma venda
   - `DELETE /orders/{id}`: Remover uma venda

## Exemplo de Requisição (Adição de Produto)

```http
POST /products
Content-Type: application/json

{
        "name": "Livro",
        "description": "Um livro",
        "price": 9.5,
        "imgUrl": "",
        "categories": []        
}
