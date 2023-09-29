Desafio 3:
Technical Debt: Escalabilidade da Fila de atendimento Ao realizar um teste de carga na aplicação, o time de performance
da Cielo identificou um problema de escalabilidade na fila de atendimento criada no desafio “2”:
Durante o teste de carga foi possível identificar que a fila em memória suportava um limite insuficiente para os
requisitos de negócio. Ao atingir o limite de memória, a aplicação abortou. Na tentativa de fazer com que a aplicação
suportasse um volume maior de requisições, o time de performance solicitou ao time de devops a configuração de
provisionamento automático de novas instâncias da aplicação conforme atingisse um certo consumo de memória. A
configuração acabou por afetar os requisitos de negócio, porque como a fila foi implementada internamente, novas
instâncias resultaram em filas apartadas, afetando os requisitos de negócio. Além disso, a área de negócio notou que ao
reiniciar a aplicação, todos os clientes da fila foram perdidos. Isso ocorria porque a aplicação armazenava os clientes
em memória, e os prospects da fila eram perdidos quando a aplicação era finalizada. Para resolver este débito técnico o
time de arquitetura orientou a utilização de uma solução de fila mais robusta e escalável, recomendando também a
utilização da solução de mensageria SQS da AWS. Desafio:
Desenhe e implemente uma nova solução para a fila de atendimento, utilizando a solução de mensageria SQS da AWS.

============================================

- Basicamente a ideia é foi criar uma integraçao com o sqs e substituir a chamada da minha queue para utilizar essa
  integraçao.

- Deixei um arquivo do terraform de como montar a fila no sqs, a fila esta criada na minha conta de sandbox;
