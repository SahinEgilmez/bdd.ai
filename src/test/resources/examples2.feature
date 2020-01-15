@allTests
Feature: Examples 2

  Background:
    Given I launch any device
    Then I wait 1 seconds

  Scenario: My Account
    When I click ai:music
    Then I see "Şarkı Listeleri"

    When I click ai:user
    Then I see "Profilim"

    When I click ai:arrow left
    Then I see "Video Listeleri"

    When I click ai:settings
    Then I see "hesabım"