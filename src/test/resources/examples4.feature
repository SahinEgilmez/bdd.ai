@allTests
Feature: Example 4

  Background:
    Given I launch any device
    Then I wait 3 seconds

  Scenario: Check Search Results
    When I click ai:search
    Then I click search_src_text
    And I enter Tarkan Yolla
    And I hide keyboard
    And I wait 5 seconds

    When I see "Yolla"
    Then I see "ŞARKILAR"
    And I see "SANATÇILAR"