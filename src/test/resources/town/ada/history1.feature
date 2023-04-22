Feature: Acesso ao Menu

  Scenario: 1.1 Acesso a pagina de informações
    Given que estou na página do the town 'https://thetown.com.br/pt/'
    When clicar no link 'Informações'
    Then devo ser redirecionado para a pagina de '/informacoes'

  Scenario: 1.4 Abrir corretamente dropdown das Duvidas mais frequentes Quando e onde acontecerá
    Given que estou na página de informações 'https://thetown.com.br/pt/informacoes/'
    When descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e selecionado o dropdown de QUANDO E ONDE ACONTECERÁ
    Then deverá ser exibido em tela as seguintes informações 'Dias 2, 3, 7, 9 e 10 de setembro' e 'Cidade da Música - Autódromo de Interlagos'

  Scenario: 1.5 Abrir corretamente dropdown das Duvidas mais frequentes Haverá cobrança de taxa de serviço
    Given que já estou na página de informações 'https://thetown.com.br/pt/informacoes/'
    When descer até a sessão de DÚVIDAS MAIS FREQUENTES e selecionado o dropdown de Quando será a venda dos ingressos do The Town
    Then deverá exibir na tela as seguintes informações 'A venda dos ingressos para o público em geral começa dia 18/04/2023, às 19h.' e 'Clientes The Town Club e clientes com cartão de crédito Itaú, Credicard ou Iti têm acesso exclusivo às respectivas Pré-vendas, que ocorrerão entre os dias 11/04, as 19h, e 17/04, as 19h.'

  Scenario: 1.6 Redirecionar para a FAQ
    Given que entrei na página de informações 'https://thetown.com.br/pt/informacoes/'
    When descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e clicar no botão 'VER TODAS AS DÚVIDAS'
    Then devo ser direcionado para a página 'https://thetown.com.br/pt/faqs/'

  Scenario: 1.7 Redirecionar para o Line Up
    Given que entrei na página de informaçoes do The Town 'https://thetown.com.br/pt/informacoes/'
    When descer, na página, até sessão de DÚVIDAS MAIS FREQUENTES e clicar no link 'LINE UP'
    Then devo ser direcionado para 'https://thetown.com.br/pt/lineup/'