Desafio 2:
User Story: Fila de atendimento Como área de Comercialização da Cielo, desejo ter uma fila de atendimento aos prospect,
para que cada cliente possa ser analisado de forma sequencial pelos gestores comerciais. Regras:

1) Toda vez que um novo cadastro ou uma alteração de cadastro for realizada no sistema, o cliente deverá entrar na
   última posição da fila de atendimento.
2) Possibilitar a retirada do cliente na primeira posição da fila de atendimento, apresentando seus dados para o
   tratamento.
3) Caso o gestor comercial solicite um prospect da fila para atendimento e não houver nenhum cliente na fila, deverá
   retornar um status coerente informando que a fila de atendimento está vazia. Desafio:
   a) incluir na API criada no desafio “1” uma nova operação que possibilite a retirada do próximo cliente da fila de
   atendimento e retorne os dados disponíveis b) implementar na linguagem java uma estrutura de dados para uma fila
   utilizando apenas tipos de dados primitivos (sem utilizar classes java.util.*), onde seja possível acrescentar e
   retirar clientes na fila no modelo FIFO (First In, First Out). c) contemplar as regras da história de usuário através
   da implementação da operação modelada no item “a”, utilizando a estrutura de fila criada no item “b” d) Implementar
   cobertura de 70% de testes unitários

===========================================

- feita a fila utilizando linked list e generics

- implementado adiciona e retira da fila (criei uma classe separada para cliente para ficar mais simples a
  implementaçao)
