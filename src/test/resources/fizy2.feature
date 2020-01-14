@featureTag
Feature: Fizy Anasayfa

  Background:
    Then I will wait 3 seconds

  @scenarioTag2
  Scenario: 4NA AkordeonFizyPremiumaGelPremiumaGec
    Given I will launch device emulator_2
    And I will wait 2 seconds
    Given I will click ai:search
    When I will see img:accordion_premium_header in 5.0 seconds
    When I will click img:accordion_expand_button

    When I will see img:accordion_premium_big_field
    When I will see img:accordion_cancel_button
    When I will click img:accordion_get_premium_button

    When I will see img:buyable_memberships_header