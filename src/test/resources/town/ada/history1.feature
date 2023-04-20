Feature: Acesso ao Menu

  Scenario: Acesso a pagina de informações
    Given que estou na página do the town 'https://thetown.com.br/pt/'
    When clicar no link 'Informações'
    Then devo ser redirecionado para a pagina de '/informacoes'

  Scenario: Abrir corretamente dropdown das Duvidas mais frequentes
    Given que estou na página de informações 'https://thetown.com.br/pt/informacoes/'
    When descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e selecionado o dropdown de QUANDO E ONDE ACONTECERÁ
    Then deverá ser exibido em tela as seguintes informações 'Dias 2, 3, 7, 9 e 10 de setembro' e 'Cidade da Música - Autódromo de Interlagos'

  Scenario: Redirecionar corretamente para a FAQ
    Given que entrei na página de informações 'https://thetown.com.br/pt/informacoes/'
    When descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e clicar no botão 'VER TODAS AS DÚVIDAS'
    Then devo ser direcionado para a página 'https://thetown.com.br/pt/faqs/'