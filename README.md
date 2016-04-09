# OpenWeather

Aplicação simples de consulta de previsão de tempo desenvolvida como forma de
comprovação de conhecimento em AngularJS e tecnologias JEE. Os dados para a
previsão são extraídos do serviço
[OpenWeather.org](http://openweathermap.org/api).

### Pré-requisitos

Não foi utilizado um gerenciador de dependências, portanto é necessário apenas
possuir as seguintes ferramentas:

* Servidor JEE 6 (ex.: Tomcat 7)
* MySQL 5.6
* Eclipse JEE 4.2

### Configuração 

No MySQL, importe a base através do arquivo
[openweather.sql](https://raw.githubusercontent.com/leanseefeld/openweather/master/resources/openweather.sql). 
Pode ser necessário editar o arquivo `/openweather/src/META-INF/persistence.xml` para configurar corretamente sua base.
Em seguida, faça o deploy do projeto pelo Eclipse.

Ao acessar a URL local (provavelmente
[http://localhost:8080/openweather](http://localhost:8080/openweather)), você
deve visualizar a aplicação conforme abaixo:

![Previsão de
tempo](https://raw.githubusercontent.com/leanseefeld/openweather/master/resources/preview.png)

## Arquitetura e Design

Ao ser carregada, a aplicação cliente solicita ao servidor a lista de cidades
favoritas. A requisição é processada no servidor pela classe
`FavoritesResource`, a qual faz uso de JAX-RS (biblioteca Jersey) para
disponibilizar os métodos da API. Esta classe, por sua vez, solicita a lista
de cidades favoritas para a classe `FavoritesDAO`, que faz uso de JPA
(biblioteca Hibernate) para buscar as cidades favoritas do banco de dados. Uma
vez que as cidades favoritas foram obtidas do servidor, a aplicação cliente
obtém os dados da previsão diretamente do *OpenWeather*.

O servidor desenvolvido não se comunica com o *OpenWeather* pois como este
serviço retorna JSON há praticidade em se trabalhar com o retorno diretamente
em JavaScript. Além do mais, é possível executar até 60 requisições por
minuto, amenizando a necessidade de implementar cache.

A aplicação cliente, desenvolvida em AngularJS, possui um controlador para
gerenciamento das cidades favoritas (é possível cadastrar e remover favoritos)
e um para a exibição e consulta de previsões.
Foi criada uma diretiva para exibição das cidades pois a mesma possui uma ação própria (seleção).

## Melhorias

No servidor, o projeto poderia ser adaptado para um gerenciador de dependências, como Maven ou Gradle.

No cliente, poderia ser criada uma diretiva para exibição da previsão de cada dia, que hoje é realizada através de `ng-repeat` e possui código duplicado no HTML.
Poderia também ser utilizado um pré-processador CSS para melhorar a legibilidade do arquivo CSS.
Em questão de usabilidade, as previsões deveriam possuir uma divisão clara entre os dias. Atualmente são listadas as previsões de 3 em 3 horas, sendo identificadas pela data.

