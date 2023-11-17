#Author:icaroiyusuka@gmail.com
#Keywords Summary:
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#"""(Doc String)
#| (Data Tables)
#@ (Tags/Labels): To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Cliente faz saque de dinheiro Como um cliente,
  eu gostaria de sacar dinheiro em caixa eletrônico,
  para que eu não tenha que esperar em uma fila do banco.

  @tag1
  Scenario: Cliente especial com saldo negativo
    Given um cliente especial com saldo atual de -200 reais
    When for solicitar um saque no valor de 100 reias