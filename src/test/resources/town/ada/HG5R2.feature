#language: pt

Funcionalidade: Validar Lineup

  Cenário: Acessar o lineup
    Dado que acesso o site
    Quando for selecionada a opção "LINE-UP"
    Então o usuário deve ser redirecionado para a página "The Town | Lineup"

  Cenário: Acessar o LINE-UP pelo carrossel
    Dado que acesso o site
    Quando avançar no carrossel e chegar no banner de Lineup
    Então o usuário deve ser redirecionado para a página "The Town | Lineup"

  Cenário: Validar o filtro "Por Dia"
    Dado que acesso o site
    Quando for selecionada a opção "LINE-UP"
    E clico na opção "POR DIA"
    Então o usuário deve ser redirecionado para a URL do primeiro dia disponível

  Cenário: Validar o filtro "Por Dia" ao ser direcionado as páginas esperadas
    Dado que acesso o site
    Quando for selecionada a opção "LINE-UP"
    E clico na opção "POR DIA"
    Então quando clico nos dias exibidos o usuário deve ser redirecionado para a URL do dia disponível

  Cenário: Acessar o filtro "Por Palco" e validar o direcionamento as páginas esperadas
    Dado que acesso o site
    Quando for selecionada a opção "LINE-UP"
    E clico na opção "POR PALCO"
    Então quando clico nos palcos exibidos são exibidos os dias e os cantores

  Cenário: Ao acessar o filtro "Por Dia" deve redirecionar para as páginas correspondentes aos cantores
    Dado que acesso o site
    Quando for selecionada a opção "LINE-UP"
    E clico na opção "POR DIA"
    Então quando clico nos cantores a página é redirecionada de acordo com o palco e dia