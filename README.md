# API de busca de pontos de interesse

Minha implementação de uma API que faz a busca de pontos de interesse com base na localização do usuario e de uma distância maxima.

Link do desafio: https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md

## Tecnologias

- Java 21
- Spring Boot 3
- Spring JPA
- PostgreSQL
- Flyway
- Docker
- OpenAPI Swagger
- JUnit + Mockito


## Como executar o projeto

subindo o banco em container docker

```bash
docker-compose up -d
```

Rodando o backend
```base
mvn spring-boot:run
```

## Acessando a documentação do projeto (Swagger)

```bash
http://localhost:8080/swagger-ui/index.html
```

