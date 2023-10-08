# Desafio de Navegação de Robôs em Marte


## O Problema

### Terreno de Exploração

O terreno de exploração em Marte é representado por um plano retangular. Cada posição no plano é identificada por um par de coordenadas (x, y) e uma orientação. A orientação pode ser uma das quatro direções: 'NORTH' (Norte), 'SOUTH' (Sul), 'EAST' (Leste) ou 'WEST' (Oeste).

### Comandos

Para controlar os robôs, a NASA envia uma sequência de comandos em forma de string. Cada comando pode conter as seguintes instruções:
- 'L': Faz o robô girar 90 graus à esquerda sem se mover da posição atual.
- 'R': Faz o robô girar 90 graus à direita sem se mover da posição atual.
- 'M': Faz o robô mover-se uma posição para a frente na direção atual.

### Posição Inicial

Uma posição válida para um robô é representada por um conjunto de coordenadas (x, y) e uma orientação. Por exemplo, a posição (0, 0, N) significa que o robô está localizado no canto inferior esquerdo do terreno, voltado para o Norte.

### Objetivo

O objetivo é criar um sistema que permita aos robôs explorar o terreno de Marte de acordo com os comandos recebidos. Os robôs devem enviar imagens da região explorada de volta à Terra.

## Solução

O sistema desenvolvido em Java, utilizou as seguintes tecnologias:

- **Java**: A linguagem de programação principal utilizada para desenvolver a solução.
- **Maven**: Uma ferramenta de gerenciamento de dependências que ajuda a gerenciar as bibliotecas e pacotes necessários para o projeto.
- **Spring Boot**: Um framework que simplifica o desenvolvimento de aplicativos Java, oferecendo recursos como injeção de dependência e configuração automática.
- **Lombok**: Uma biblioteca que simplifica a criação de código Java, reduzindo a quantidade de código repetitivo, como getters e setters.
- **Java Bean Validation**: Uma especificação que fornece um mecanismo de validação de dados.
- **Mockito**: Uma biblioteca de teste para Java que permite criar objetos simulados para testar o comportamento de classes.

Aqui estão as principais classes envolvidas na solução do desafio:

- `Robot`: Representa um robô e sua posição no terreno. Possui métodos para executar comandos.
- `RobotPosition`: Representa uma posição no terreno.
- `CommandConverter`: Converte uma string de comandos em uma lista de comandos executáveis para um robô.
- `MoveForwardCommand`, `TurnLeftRobotCommand`, `TurnRightRobotCommand`: Implementam os comandos específicos que um robô pode executar.
- `RobotService`: Um serviço que coordena a execução dos comandos pelos robôs e valida as posições.
- **Testes Unitários**: São implementados testes unitários para cada classe, verificando se os comandos e a lógica de movimento funcionam corretamente.

## Como Executar

Para executar o sistema, siga estas etapas:

1. Configure um ambiente de desenvolvimento Java com as dependências necessárias, incluindo Maven.
2. Executar o comando `mvn clean` install no diretório raiz do projeto.
3. Após a execução comando, será gerado um arquivo challengerobot-0.0.1-SNAPSHOT.jar no diretório target. Para executá-lo utilizar o comando `java -jar challengerobot-0.0.1-SNAPSHOT.jar`
4. A aplicação estará executando na porta HTTP 8080, ou seja, estará respondendo aos comandos no endereço **http://localhost:8080/rest/mars/**

