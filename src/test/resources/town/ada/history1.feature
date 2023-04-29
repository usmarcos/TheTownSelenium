Feature: Acesso ao Menu

  Scenario: 1.1 Acesso a pagina de informações
    Given que estou na página do the town 'https://thetown.com.br/pt/'
    When clicar no link 'Informações'
    Then devo ser redirecionado para a pagina de 'https://thetown.com.br/pt/informacoes/'

    #Não foi possível automatizar.
  #Scenario: 1.2 EXIBIR OS BALÕES DE LEITURA CORRETAMENTE NO MAPA INTERATIVO
   # Given que clico no menu 'Informações' na pagina 'https://thetown.com.br/pt/'
   # When descer até o mapa interativo
   # And clico no balão com numero 6
   # Then deverá aparecer a mensagem com as informações do palco 'Factory'


  Scenario Outline: 1.4 e 1.5 Abrir corretamente dropdown das Duvidas mais frequentes Quando e onde acontecerá
    Given que estou na página de informações <link>
    When descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e selecionado o dropdown <buttonText>
    Then deverá ser exibido em tela as seguintes informações <texto1> <xpath1> e <texto2> <xpath2>

    Examples:
      | link                                     | buttonText                                                        | texto1                                                                         | xpath1                                                               | texto2                                                                                                                                                                                       | xpath2                                                               |
      | "https://thetown.com.br/pt/informacoes/" | "/html/body/div/div[2]/section[8]/div[2]/div[1]/div[1]/h2/button" | "Dias 2, 3, 7, 9 e 10 de setembro"                                             | "/html/body/div/div[2]/section[8]/div[2]/div[1]/div[1]/div/div/p[1]" | "Cidade da Música - Autódromo de Interlagos"                                                                                                                                                 | "/html/body/div/div[2]/section[8]/div[2]/div[1]/div[1]/div/div/p[2]" |
      | "https://thetown.com.br/pt/informacoes/" | "/html/body/div/div[2]/section[8]/div[2]/div[1]/div[4]/h2/button" | "A venda dos ingressos para o público em geral começa dia 18/04/2023, às 19h." | "/html/body/div/div[2]/section[8]/div[2]/div[1]/div[4]/div/div/p[1]" | "Clientes The Town Club e clientes com cartão de crédito Itaú, Credicard ou Iti têm acesso exclusivo às respectivas Pré-vendas, que ocorrerão entre os dias 11/04, as 19h, e 17/04, as 19h." | "/html/body/div/div[2]/section[8]/div[2]/div[1]/div[4]/div/div/p[2]" |

  #Scenario: 1.5 Abrir corretamente dropdown das Duvidas mais frequentes Haverá cobrança de taxa de serviço
   # Given que já estou na página de informações 'https://thetown.com.br/pt/informacoes/'
   # When descer até a sessão de DÚVIDAS MAIS FREQUENTES e selecionado o dropdown de Quando será a venda dos ingressos do The Town
   # Then deverá exibir na tela as seguintes informações 'A venda dos ingressos para o público em geral começa dia 18/04/2023, às 19h.' e 'Clientes The Town Club e clientes com cartão de crédito Itaú, Credicard ou Iti têm acesso exclusivo às respectivas Pré-vendas, que ocorrerão entre os dias 11/04, as 19h, e 17/04, as 19h.'

  Scenario Outline: 1.6, 1.7, 1.8, 1.9, 1.10, 1.18 Redirecionamentos
    Given que entrei na página de informações <link>
    When descer a página até a sessão de DÚVIDAS MAIS FREQUENTES e clicar no botão <text>
    Then devo ser direcionado para a página <page>

    Examples:
      | link                                     | text                   | page                                  |
      | "https://thetown.com.br/pt/informacoes/" | "VER TODAS AS DÚVIDAS" | "https://thetown.com.br/pt/faqs/"     |
      | "https://thetown.com.br/pt/informacoes/" | "LINE UP"              | "https://thetown.com.br/pt/lineup/"   |
      | "https://thetown.com.br/pt/informacoes/" | "FAQ"                  | "https://thetown.com.br/pt/faqs/"     |
      | "https://thetown.com.br/pt/informacoes/" | "NOTÍCIAS"             | "https://thetown.com.br/pt/noticias/" |
      | "https://thetown.com.br/pt/informacoes/" | "HOME"                 | "https://thetown.com.br/pt/"          |
      | "https://thetown.com.br/pt/informacoes/" | "O FESTIVAL"           | "https://thetown.com.br/pt/festival/"          |

  #Scenario: 1.7 Redirecionar para o Line Up
    #Given que entrei na página de informaçoes do The Town 'https://thetown.com.br/pt/informacoes/'
    #When descer, na página, até sessão de DÚVIDAS MAIS FREQUENTES e clicar no link 'LINE UP'
    #Then devo ser direcionado para 'https://thetown.com.br/pt/lineup/'

  #Scenario: 1.8 Redirecionar para FAQ com FAQ SAIBA MAIS
    #Given estou em 'https://thetown.com.br/pt/informacoes/' da página do The Town
    #When clicar no link 'FAQ' SAIBA MAIS
    #Then devo ir para a página 'https://thetown.com.br/pt/faqs/'

  #Scenario: 1.9 Redirecionar para noticias
   # Given que a partir da pagina de informações 'https://thetown.com.br/pt/informacoes/' quero acessar a pagina de noticias
   # When clicar no link de noticias 'NOTÍCIAS' SAIBA MAIS
   # Then devo ser redirecionado para a pagina de noticias 'https://thetown.com.br/pt/noticias/'

  #Scenario: 1.10 Voltar para a pagina inicial
   # Given que na pagina de informações 'https://thetown.com.br/pt/informacoes/' quero acessar a pagina HOME
   # When clicar no link home 'HOME'
   # Then devo voltar para a página inicial 'https://thetown.com.br/pt/'

  Scenario Outline: 1.11, 1.12, 1.13, 1.14, 1.15, 1.16, 1.17 Clicar no link do patrocinador master
    Given que estou na pagina <menu>
    When descer na página de informações e clicar na imagem da Heineken Patrocinador master <xpath>
    Then devo ser direcionado para a página da heineken brasil <page>

    Examples:
      | menu                                     | xpath                                                                      | page                                                                                                                                         |
      | "https://thetown.com.br/pt/informacoes/" | "/html/body/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/div/a/img"      | "https://www.heinekenbrasil.com.br/?utm_source=site&utm_medium=the_town&utm_content=site_thetown_patrocinador&utm_campaign=thetown_heineken" |
      | "https://thetown.com.br/pt/informacoes/" | "/html/body/div/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/a/img"      | "https://www.capital.sp.gov.br/?utm_source=site&utm_medium=the_town&utm_content=site_thetown_apoio&utm_campaign=thetown_cidadedesaopaulo"    |
      | "https://thetown.com.br/pt/informacoes/" | "/html/body/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[7]/a/img"   | "https://www.coca-cola.com.br/?utm_source=site&utm_medium=the_town&utm_content=site_thetown_patrocinador&utm_campaign=thetown_cocacola"      |
      | "https://thetown.com.br/pt/informacoes/" | "/html/body/div/div[2]/div[2]/div[2]/div/div[4]/div/div[2]/div[7]/a/img"   | "https://www.radiorock.com.br/?utm_source=site&utm_medium=the_town&utm_content=site_thetown_mediapartner&utm_campaign=thetown_radio89"       |
      | "https://thetown.com.br/pt/informacoes/" | "/html/body/div/div[2]/div[2]/div[2]/div/div[5]/div/div[2]/div/a/img"      | "https://www.tiktok.com/?utm_source=&utm_medium=the_town&utm_content=site_thetown_contentpartner&utm_campaign=thetown_tiktok"                |
      | "https://thetown.com.br/pt/informacoes/" | "/html/body/div/div[2]/div[2]/div[2]/div/div[6]/div/div[2]/div[5]/a/img"   | "https://www.instagram.com/trident_brasil/"                                                                                                  |
      | "https://thetown.com.br/pt/informacoes/" | "/html/body/div/div[2]/div[2]/footer/div/div[3]/div/div[1]/div/ul/li[6]/a" | "https://thetown.empregare.com/pt-br/vagas"                                                                                                  |

  #Scenario: 1.12 Clicar no Link de apoio institucional
   # Given que na pagina 'https://thetown.com.br/pt/informacoes/' quero acessar o link de apoio institucional
   # When descer até apoio institucional e clicar no incone do estado de SP
   # Then devo ser redirecionado para 'https://www.capital.sp.gov.br/?utm_source=site&utm_medium=the_town&utm_content=site_thetown_apoio&utm_campaign=thetown_cidadedesaopaulo'

  #Scenario: 1.18 Funcionamento da pagina Trabalhe conosco
    #Given que a partir da pagina home 'https://thetown.com.br/pt/', clico no link de 'INFORMAÇÕES'
    #When descer a pagina até o rodapé
    #And clicar em 'O FESTIVAL'
    #Then devo ser direcionado para a página de festival 'https://thetown.com.br/pt/festival/'
