Feature: Acesso ao Menu

  Scenario: 1.1 Acesso a pagina de informações
    Given que estou na página do the town 'https://thetown.com.br/pt/'
    When clicar no link 'Informações'
    Then devo ser redirecionado para a pagina de 'https://thetown.com.br/pt/informacoes/'

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

  Scenario: 1.8 Redirecionar para FAQ com FAQ SAIBA MAIS
    Given estou em 'https://thetown.com.br/pt/informacoes/' da página do The Town
    When clicar no link 'FAQ' SAIBA MAIS
    Then devo ir para a página 'https://thetown.com.br/pt/faqs/'

  Scenario: 1.9 Redirecionar para noticias
    Given que a partir da pagina de informações 'https://thetown.com.br/pt/informacoes/' quero acessar a pagina de noticias
    When clicar no link de noticias 'NOTÍCIAS' SAIBA MAIS
    Then devo ser redirecionado para a pagina de noticias 'https://thetown.com.br/pt/noticias/'

  Scenario: 1.10 Voltar para a pagina inicial
    Given que na pagina de informações 'https://thetown.com.br/pt/informacoes/' quero acessar a pagina HOME
    When clicar no link home 'HOME'
    Then devo voltar para a página inicial 'https://thetown.com.br/pt/'

  Scenario: 1.11 Clicar no link do patrocinador master
    Given que clico no link de 'INFORMAÇÕES' a partir de 'https://thetown.com.br/pt/'
    When descer na página de informações e clicar na imagem da Heineken Patrocinador master
    Then devo ser direcionado para a página da heineken brasil 'https://www.heinekenbrasil.com.br/?utm_source=site&utm_medium=the_town&utm_content=site_thetown_patrocinador&utm_campaign=thetown_heineken'

  Scenario: 1.12 Clicar no Link de apoio institucional
    Given que na pagina 'https://thetown.com.br/pt/informacoes/' quero acessar o link de apoio institucional
    When descer até apoio institucional e clicar no incone do estado de SP
    Then devo ser redirecionado para 'https://www.capital.sp.gov.br/?utm_source=site&utm_medium=the_town&utm_content=site_thetown_apoio&utm_campaign=thetown_cidadedesaopaulo'

  Scenario: 1.18 Funcionamento da pagina Trabalhe conosco
    Given que a partir da pagina home 'https://thetown.com.br/pt/', clico no link de 'INFORMAÇÕES'
    When descer a pagina até o rodapé
    And clicar em 'O FESTIVAL'
    Then devo ser direcionado para a página de festival 'https://thetown.com.br/pt/festival/'
