# Microservice Chassis Spring Boot
Este projeto é um microservice chassis e pode ser utilizado como base na criação de novos microserviços.

Este chassis foi criado a partir das necessidades basicas de um microserviço, com cliente HTTP e persistência em banco de dados. 
Conforme a necesside, libs que fizerem necessárias ao cenário do seu projeto poderão ser adicionadas ou removidas.

# Arquitetura
Utilizamos como base, a implementação da arquitetura hexagonal proposta pela Netflix, conheça um pouco mais clicando [aqui](https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749).

### Camadas
O modelo proposto pela Netflix, possui um isolamento baseado em dois conceitos, sendo eles: business-logic e adapters. Dado esse conceito,
fizemos uma pequena modificação isolando os pacotes que fazem parte do business-logic no pacote `internal`, e os pacotes de fronteiras dentro do pacote `adapter`.

Abaixo, breve descrição da responsabilidade de cada camada.

- **Transport Layer**: É a camada a qual aciona uma regra de negócio, sendo reponsável pela entrada de dados do mundo externo, para nossa aplicação.
Aqui podem ficar nossos http providers, como por exemplo REST e GraphQL. Ou até mesmo consumers de message brokers como AWS SQS Listeners, Kafka Consumer e Redis Subscribers. 
  
- **Interactor**: Responsável por parte da lógica de negócio, recebe os dados da camada de transport e delega, se necessário, para a camada de datasource. 

- **Entities**: Responsável por mapear o nosso dominio e parte da lógica de negócio junto aos interactors. Devendo a todo custo
evitar dependências de frameworks e libs externas, ex: Lombok, notações Spring e etc.

- **Datasource**: É a camada que recebe um acionamento vindo de uma regra de negócio, responsável por direcionar o conteúdo
para a fonte de dados correta, podendo ser um AWS SQS Producer, AWS S3, arquivos CSV em disco, etc. *Esta camada pode ter mais de uma implementação.*

```markdown
📦 src
┣ 📦 main/java/dev/zevolution/netflixhexaarch
┃ ┣ 📂 adapter: Adaptadores responsavéis por acionar ou serem acionados a partir de eventos externos ou do bussiness-logic
┃ ┃ ┣ 📂 datasources: Todas as fontes de dados utilizadas pela aplicação
┃ ┃ ┃ ┣ 📂 services: Serviço que podem vir a ser utilizados pelas fontes de dados, ex: uma class Feign Client
┃ ┃ ┃ ┃ ┣ 📂 data: DTO's de request e response utilizados pelos services acima
┃ ┃ ┃ ┃ ┃ ┣ 📂 request:
┃ ┃ ┃ ┃ ┃ ┣ 📂 response:
┃ ┃ ┃ ┃ ┣ 📂 mapper: Classes mapeadores, responsáveis por mapear os DTO's dos services, para entidades do bussiness-logic(internal)
┃ ┃ ┃ ┃ ┣ 📂 model: Classes responsáveis por mapear as entidades de banco de dados, aqui, podemos utilizar anotações como @Entity, @Column, etc...
┃ ┃ ┣ 📂 properties: Classes responsáveis por mapear properties existentes no application.yml
┃ ┃ ┣ 📂 transportlayers: Todas as fontes para entrada de dados na nossa aplicação, ex: Controllers, Consumers, Socket, etc ...
┃ ┃ ┃ ┣ 📂 mapper: Classes mapeadores, responsáveis por mapear os DTO's da transportlayer, para entidades do bussiness-logic(internal) e vice-versa
┃ ┃ ┃ ┣ 📂 restapi(example): Exemplo de onde podemos adicionar nossos Controllers
┃ ┃ ┃ ┣ 📂 messagebrokers(example): Exemplo de onde podemos adicionar nossos Listeners, Consumers e Subscribers
┃ ┃ ┃ ┣ 📂 graphql(example): Exemplo de onde podemos adicionar nossos Controllers
┃ ┣ 📂 bootstrap: Classes de configuração da aplicação
┃ ┃ ┣ 📂 exceptions: Exceções da aplicação, podendo ser compartilhada entre camadas
┃ ┣ 📂 internal: Contem tudo relacionado a Business-Logic
┃ ┃ ┣ 📂 entities: Classes utilizadas para mapeamento do nosso negócio/dominio
┃ ┃ ┣ 📂 interactors: Classes responsável por regras de negócio especificas
┃ ┃ ┣ 📂 properties: Classes responsáveis por mapear properties existentes no application.yml
┃ ┃ ┣ 📂 repositories: Interfaces responsáveis por especificar para o datasource, qual o input e retorno exigido pelo nosso domínio 
┃ ┗ 📜 Application.java: Classe inicializadora
┣ 📦 main/resources
┃ ┣ 📜 application.yml
┃ ┣ 📜 bootstrap.yml
┃ ┗ 📜 openapi.yml
┣ 📜 .gitignore
┣ 📜 Dockerfile
┣ 📜 pom.xml
┗ 📜 README.MD
```

# Tecnologias
Foi utilizado na criação deste chassis bibliotecas como: 
* [Java 11](https://openjdk.java.net/projects/jdk/11/)
* [Maven](https://maven.apache.org/)
* [Spring-Boot 2.5.0](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/)
* [SpringFox 3](https://github.com/springfox/springfox/releases/tag/3.0.0)
* [MapStruct](https://mapstruct.org/documentation/stable/reference/html/)
* [OpenFeign](https://spring.io/projects/spring-cloud-openfeign)
* [JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
* [OpenAPI Generator](https://github.com/OpenAPITools/openapi-generator)
  * O chassis está gerando o código a partir da especificação em `src/main/resources/openapi.yml`
* [Micrometer Registry Prometheus]()

# URLs
 - Documentação swagger do próprio chassis: `http://localhost:8080/project-artifact/swagger-ui/`
 - Spring Actuator: `http://localhost:9090/actuator`
 - Métricas prometheus: `http://localhost:9090/actuator/prometheus`

# Exemplos de implementação
- [Transport RESTAPI | Datasource Feign Client](https://github.com/zevolution/netflix-hexagonal-architecture)