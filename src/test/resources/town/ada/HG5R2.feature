#language: pt

Funcionalidade: Validar Lineup

  Cenário: Acessar corretamente o lineup
    Dado que acesso o site
    Quando for selecionada a opção "LINE-UP"
    Então o usuário deve ser redirecionado para a página "The Town | Lineup"

  Cenário: Acessar corretamente o LINE-UP pelo carrossel
    Dado que acesso o site
    Quando avançar no carrossel e chegar no banner de Lineup
    Então o usuário deve ser redirecionado para a página "The Town | Lineup"

  Cenário: Acessar corretamente o filtro "Por Dia"
    Dado que acesso o site
    Quando for selecionada a opção "LINE-UP"
    E clico na opção "POR DIA"
    Então o usuário deve ser redirecionado para a URL do primeiro dia disponível

  Cenário: Acessar corretamente o filtro "Por Dia" e ser direcionado as páginas esperadas
    Dado que acesso o site
    Quando for selecionada a opção "LINE-UP"
    E clico na opção "POR DIA"
    Então quando clico nos dias exibidos o usuário deve ser redirecionado para a URL do dia disponível

