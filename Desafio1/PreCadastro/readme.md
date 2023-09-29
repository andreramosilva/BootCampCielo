Desafio 1:
User Story: Pré-cadastro de clientes Como área de Comercialização da Cielo, desejo manter um pré-cadastro de clientes
(prospect) para possibilitar uma futura oferta de produtos e serviços a esses clientes. Regras:

1) Informações do cadastro:
   a) Se Pessoa Jurídica:
   • CNPJ o número de 14 dígitos formatado com zeros à esquerda • Razão Social o máximo de 50 caracteres • MCC -
   “Merchant Category Code“ o número com no máximo 4 caracteres • CPF do contato do estabelecimento o número de 11
   dígitos formatado com zeros à esquerda • Nome do contato do estabelecimento o máximo de 50 caracteres • Email do
   contato do estabelecimento o expressão regular para validação:
   "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\.]+)\\.([a-zA-Z]{2,5})$")
   b) Se Pessoa Física:
   • CPF da pessoa o número de 11 dígitos formatado com zeros à esquerda • MCC – “Merchant Category Code” o número com
   no máximo 4 caracteres • Nome da pessoa o máximo de 50 caracteres • Email da pessoa o expressão regular para
   validação:
   "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\.]+)\\.([a-zA-Z]{2,5})$"

* Todas as informações são obrigatórias

2) Consistências:
   a) A operação de cadastrar cliente deverá validar se o cadastro não existe. Se o cadastro já existir, o sistema
   deverá retornar um status coerente informando que o cliente já está cadastrado e não realizar qualquer alteração nos
   dados existentes. b) A operação de alterar cliente deverá validar se o cadastro já existe. Se o cadastro não existir,
   o sistema deverá retornar um status coerente informando que o cliente ainda não está cadastrado e não deverá realizar
   a inclusão de um novo registro. c) Ambas as operações de cadastrar ou alterar cliente deverão validar se todos os
   dados foram informados, se estão consistentes conforme tamanhos, tipos de dados e formatações disponibilizadas na
   regra “1”. Em caso de qualquer inconsistência, o sistema deverá retornar um status coerente informando os detalhes do
   erro. d) A operação de consultar um cliente deverá validar se o cadastro já existe. Se o cadastro não existir, o
   sistema deverá retornar um status coerente informando que o cliente ainda não está cadastrado. Desafio:
   a) modelar uma API REST com operações que possibilitem a criação, alteração, exclusão e consulta de pré-cadastros de
   clientes. O entregável deverá ser um documento swagger. b) implementar na linguagem java utilizando o framework
   spring boot as APIs modeladas no item 1. Os dados podem ser armazenados em memória. c) Implementar cobertura de 70%
   de testes unitários

======================================================================

- pelo que entendi parte do desafio era fazer de alguma forma com apenas um endpoint(eu acabei fazendo dessa forma)

- a forma que entencontrei de fazer de forma mais organizada foi usando uma flag para identificar e trabalhar com as
  validacoes em cima disso, também tive que fazer algumas mudancas e deixei os comentarios no codigo de acordo com as
  necesidades que fui encontrando.

- imagino que a melhor forma seria quebrar e endpoints separados para cliente pf e pj, mas segui o que entendi pela
  descricao;

- para o request a forma que eu montei com base no payload a api identifica se é um cliente pf ou pj Exemplo payloads:
  -pj :
  {
  "flag":"pj",
  "cpf":"11122233396",
  "cnpj":"01027058000191",
  "razaoSocial":"CIELO",
  "nomeContato":"Robervaldo",
  "emailContato":"jaava@cgc.com",
  "mcc":"1771"
  } -pf:
  {
  "nome":"Jusicley",
  "flag":"pf",
  "cpf":"11122233396",
  "mcc":"1771"
  "email": "jaava@cgc.com"
  }
  
- tomei a liberdade de criar tratativas para os erros;
