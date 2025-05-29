# Parrot Refactoring Kata

Este repositório contém a resposta da avaliação do Teste de Performance 2 da Disciplina de Refatoração.
Nele houve a refatoração do kata *Parrot* (Emily B.), seguindo princípios de Clean Code e padrões de design do livro do Martin Fowler.

## 📋 Estrutura do Projeto

```
src/
 └── main/
     └── java/
         └── parrot/
             ├── FlightConfig.java
             ├── ParrotTypeEnum.java
             ├── SpeedStrategy.java
             ├── EuropeanSpeedStrategy.java
             ├── AfricanSpeedStrategy.java
             ├── NorwegianBlueSpeedStrategy.java
             ├── SpeedStrategyFactory.java
             ├── CryStrategy.java
             ├── EuropeanCryStrategy.java
             ├── AfricanCryStrategy.java
             ├── NorwegianBlueCryStrategy.java
             └── CryStrategyFactory.java
             └── Parrot.java

test/
 └── java/
     └── parrot/
         └── ParrotTest.java
```

## 🎯 Objetivos da Refatoração

1. **Eliminar `switch` e lógica misturada** em métodos monolíticos.
2. **Remover magic numbers** espalhados, centralizando-os em `FlightConfig`.
3. **Aplicar SRP** (Single Responsibility Principle) e **OCP** (Open/Closed Principle), isolando cada comportamento em sua própria classe.
4. **Implementar Strategy Pattern** para cálculo de velocidade e definição de som, permitindo extensão sem modificação.
5. **Manter baixos acoplamento e alta coesão**, facilitando testes unitários.

## 🔄 Passo a Passo da Refatoração

1. **Identificação de problemas**:

    * Método original `getSpeed()` combinava todos os cálculos (Europeu, Africano, Norwegian Blue) e possuía números mágicos (12.0, 9.0, 24.0).
    * Método original `getCry()` concentrava escolha de sons em um `switch` e também usava literais espalhados.
    * Construtores com muitos parâmetros dificultavam manutenção e testes.

2. **Extração de constantes**:

    * Criada utilitária `FlightConfig` com `BASE_SPEED`, `LOAD_FACTOR` e `MAX_SPEED`.

3. **Introdução de Strategy Pattern**:

    * Definidas interfaces `SpeedStrategy` e `CryStrategy`.
    * Implementadas classes específicas (`EuropeanSpeedStrategy`, `AfricanSpeedStrategy`, `NorwegianBlueSpeedStrategy`, e equivalentes para som).
    * Fábricas (`SpeedStrategyFactory` e `CryStrategyFactory`) roteiam estratégias de acordo com `ParrotTypeEnum`.
    * `Parrot` recebe apenas `type`, `numberOfCoconuts`, `voltage` e `isNailed`, e delega a lógica às strategies.

4. **Remoção de classe de configuração intermediária**:

    * Opcionalmente consolidamos parâmetros diretamente em `Parrot`, simplificando o modelo quando não há validações complexas.

5. **Atualização de testes**:

    * Adequação de `ParrotTest.java` para novo construtor e delegação de lógica.

## 🔧 Como Executar

1. **Compilar**:

   ```bash
   mvn compile
   ```

2. **Executar Testes**:

   ```bash
   mvn test
   ```

## 🔄 Evolução do Domínio e Extensibilidade

Considerando que no futuro as regras de classificação podem se modificar:

* A separação via **Strategy** e **Factory** permite adicionar novas condições ou espécies sem alterar o código existente:

    * Basta implementar `SpeedStrategy` ou `CryStrategy` adicionais.
    * Registrar a nova estratégia na fábrica correspondente.

* Para cenários avançados, podemos combinar com `Specification Pattern` e uma `ParrotFactory` que decide a espécie com base em regras mutáveis.

## 📖 Conclusão

A refatoração resultou em:

* Código mais **coeso** (cada classe faz apenas uma coisa).
* Sistema **aberto para extensão** e **fechado para modificação**.
* Redução de **magic numbers** e **switches**.
* Melhoria na **testabilidade** e **legibilidade**, garantindo fácil manutenção futura.

---
