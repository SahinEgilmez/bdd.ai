@allTests
Feature: Example 3

  Background:
    Given I launch any device
    Then I wait 3 seconds

  Scenario: Play Music
    When I click ai:search
    Then I click search_src_text
    And I enter Tarkan Yolla
    And I hide keyboard
    And I wait 5 seconds

    When I click "Yolla"
    Then I click miniPlayer
    And I see img:song_image