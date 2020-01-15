@allTests
Feature: Example 6

  Background:
    Given I launch any device
    Then I wait 3 seconds

  Scenario: Premium Popup
    When I click ai:search
    Then I click search_src_text
    And I enter Sezen Aksu
    And I hide keyboard

    When I click "Tümünü Gör"
    Then I click "Tutuklu"
    And I do not see img:premium_popup

    When I click "İki Gözüm"
    Then I see img:premium_popup
    And I click "Premium'a Geç"
    And I see img:memberships_header