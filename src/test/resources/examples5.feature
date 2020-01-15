@allTests
Feature: Example 5

  Background:
    Given I launch any device
    Then I wait 3 seconds

  Scenario: Show All Songs
    When I click ai:search
    Then I click search_src_text
    And I enter Sezen Aksu
    And I hide keyboard

    When I see "Sezen Aksu"
    Then I click "Tümünü Gör"
    And I see "Tutuklu"
    And I see "İki Gözüm"