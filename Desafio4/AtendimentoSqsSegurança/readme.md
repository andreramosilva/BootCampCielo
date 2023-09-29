Desafio 4:
Technical Debt: Segurança da Informação Desafio:
a) identifique um débito técnico de Segurança da Informação na aplicação b) detalhe o débito técnico identificado,
informando a criticidade e possíveis consequências c) planeje as atividades técnicas para o desenvolvimento da solução
d) implemente a solução

===============================================

- Falta de Autenticação e Autorização Adequadas:
  criado sistema de login, com jwt para login e controle de acesso as rotas;

- Gerenciamento de Chaves e Segredos:
  Nesse caso eu recomendaria fortemente utilizaçao de um secret vault para as credenciais da aplicaçao quando acessar
  outras aplicacoes e integraçoes No nosso caso a aplicao esta apenas rodando local por isso nao foi criado mas acho que
  seria o proximo passo caso a aplicacao for para producao/homologacao

