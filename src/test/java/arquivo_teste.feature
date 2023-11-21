Feature: Cliente faz saque de dinheiro Como um cliente,
  eu gostaria de sacar dinheiro em caixa eletrônico,
  para que eu nao tenha que esperar em uma fila do banco.

  Scenario Outline: Cliente especial com saldo negativo
    Given um cliente especial com saldo atual de <int1> reais
    When for solicitar um saque no valor de <int11> reias
    Then deve efetuar o saque e atualizar o saldo da conta para <int12> reais
    And check more outcomes
    Examples:
      | int1 | int11 | int12 |
      | -200 | 100   | -300  |



  Scenario Outline: Cliente comum com saldo negativo
    Given um cliente comum com saldo atual de <int1> reais
    When solicitar um saque de <int11> reais
    Then nao deve efetuar o saque e deve retornar a mensagem Saldo insulficiente
    Examples:
      | int1 | int11 |
      | -200 | 200   |




