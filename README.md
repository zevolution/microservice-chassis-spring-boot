# Microservice Chassis Spring Boot Archetype 

Primeiramente baixe o projeto. Logo após baixa-lo, no diretório raiz do projeto, execute o comando a seguir para que o projeto seja compilado e adicionado no seu repositorio local.

```shell
mvn clean install
```

Agora fora do diretório do projeto(em qualquer outro), com o comando a seguir podemos gerar um novo projeto no modo interativo com base no archetype construido acima.

```shell
mvn -B archetype:generate \
	-DarchetypeGroupId=dev.zevolution \
	-DarchetypeArtifactId=archetype--spring-boot \
	-DarchetypeVersion=0.0.1-SNAPSHOT \
	-DgroupId=dev.zevolution \
	-DartifactId=api--teste \
	-Dversion=0.0.1-SNAPSHOT \
	-DartifactIdToPackage=netflixhexagonalarchitecture 
```

Descritivo de cada propriedade:
* **archetypeGroupId**: groupId do arquétipo maven a ser utilizado como base
* **archetypeArtifactId**: artifactId do arquétipo maven a ser utilizado como base
* **archetypeVersion**: versão do arquétipo maven a ser utilizado
* **groupId**: groupId que será utilizado no projeto criado a partir do arquétipo
* **artifactId**: artifactId que será utilizado no projeto criado a partir do arquétipo
* **version**: versão inicial a ser utilizado no projeto cirado a partir do arquétipo
* **artifactIdToPackage**: nome do pacote raiz a ser utilizado(veja abaixo os exemplos 1, 2 e 3).
  * Por padrão este é um parâmetro obrigatório, caso nenhum valor for inserido, o nome do pacote raiz será o artifactId(formatado contendo somente letras)
  * Caso deseje criar subpackage para categorizar, utilize "/", ex: architecture/netflixhexagonal

# Exemplos
**Exemplo 1**: Utilizando `-DartifactIdToPackage=netflixhexagonalarchitecture`
```markdown
📦 src
┣ 📦 main
┃ ┣ 📦 java
┃ ┃ ┣ 📦 dev
┃ ┃ ┃ ┣ 📦 zevolution
┃ ┃ ┃ ┃ ┣ 📦 netflixhexagonalarchitecture
┃ ┃ ┃ ┃ ┃ ┣ 📂 adapter
┃ ┃ ┃ ┃ ┃ ┣ 📂 bootstrap
┃ ┃ ┃ ┃ ┃ ┣ 📂 internal
┃ ┃ ┃ ┃ ┃ ┗ 📜 Application.java
┣ 📦 main/resources
┣ 📜 .gitignore
┣ 📜 Dockerfile
┣ 📜 pom.xml
┗ 📜 README.MD
```

**Exemplo 2**: Utilizando `-DartifactIdToPackage=architecture/netflixhexagonal`
```markdown
📦 src
┣ 📦 main
┃ ┣ 📦 java
┃ ┃ ┣ 📦 dev
┃ ┃ ┃ ┣ 📦 zevolution
┃ ┃ ┃ ┃ ┣ 📦 architecture
┃ ┃ ┃ ┃ ┃ ┣ 📦 netflixhexagonal
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂 adapter
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂 bootstrap
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂 internal
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜 Application.java
┣ 📦 main/resources
┣ 📜 .gitignore
┣ 📜 Dockerfile
┣ 📜 pom.xml
┗ 📜 README.MD
```

**Exemplo 3** : NÃO utlizando a propriedade `-DartifactIdToPackage` e passando `artifactId` como `-DartifactId=api--teste`. Veja que qualquer caracter diferente de a-z, será removido
```markdown
📦 src
┣ 📦 main
┃ ┣ 📦 java
┃ ┃ ┣ 📦 dev
┃ ┃ ┃ ┣ 📦 zevolution
┃ ┃ ┃ ┃ ┣ 📦 apiteste 
┃ ┃ ┃ ┃ ┃ ┣ 📂 adapter
┃ ┃ ┃ ┃ ┃ ┣ 📂 bootstrap
┃ ┃ ┃ ┃ ┃ ┣ 📂 internal
┃ ┃ ┃ ┃ ┃ ┗ 📜 Application.java
┣ 📦 main/resources
┣ 📜 .gitignore
┣ 📜 Dockerfile
┣ 📜 pom.xml
┗ 📜 README.MD
```