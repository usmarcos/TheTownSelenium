Feature: An access page

  Scenario: Access Informations page
    Given I am in the town page 'https://thetown.com.br/pt/'
    When I click in 'Informações' link
    Then I must redirect to '/informacoes' page
