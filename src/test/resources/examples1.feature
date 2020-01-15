@allTests @test1
Feature: Example 1

  Background:
    Given I launch device emulator_2
    Then I wait 1 seconds

  Scenario: Yellow Accordion
    When I see img:accordion_premium_header
    Then I click img:accordion_expand_button

    When I see img:accordion_big_field
    Then I see img:accordion_cancel_button
    And I click "PREMİUM'A GEÇ"
    And I see img:memberships_header