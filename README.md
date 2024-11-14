# Projeto CRUD de Incidentes

Este projeto é um sistema básico de gerenciamento de incidentes (CRUD) desenvolvido com Spring Boot

## 📌 Ferramentas Utilizadas

- **[Spring Tools Suite](https://spring.io/tools)** - IDE para desenvolvimento Spring
- **[Insomnia](https://insomnia.rest)** - Ferramenta para testes de API
- **[MySQL](https://www.mysql.com/)** - Banco de dados relacional utilizado para armazenar os dados dos incidentes

## 🌐 URL das Requisições (API Endpoints)

- **URL Base**: `http://localhost:8080/api/incidentes`

### 🔍 Listar Incidentes
- **Listar todos os incidentes**:  
  `GET /listarIncidentes`  
  Exemplo: `http://localhost:8080/api/incidentes/listarIncidentes`

- **Listar 20 incidentes em ordem decrescente**:  
  `GET /ordenar`  
  Exemplo: `http://localhost:8080/api/incidentes/ordenar`

- **Obter um incidente específico**:  
  `GET /id`  
  Exemplo: `http://localhost:8080/api/incidentes/{id}`

- **Atualizar um incidente**:  
  `Put /incidente`  
  Exemplo: `http://localhost:8080/api/incidentes/{id}`

- **Encerrar um incidente**:  
  `PUT /encerrar`  
  Exemplo: `http://localhost:8080/api/incidentes/encerrar`

- **Deletar um incidente (requisição DELETE)**:  
  `DELETE /id`  
  Exemplo: `http://localhost:8080/api/incidentes/{id}`
