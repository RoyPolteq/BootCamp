Feature: Login Tests

  hier kun je vrije tekst invullen om de feature uit te leggen, bijv een user story (as - I - So)

  Scenario: A valid customer should be able to login
    Given I am on the Polteq great testshop
    When I log in as "roy91191@hotmail.com" with password "Test01"
    Then  I should be logged in