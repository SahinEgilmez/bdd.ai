@featureTag
Feature: Fizy Anasayfa

  Background:
    Given I will launch device emulator_1
    Then I will wait 3 seconds

  @scenarioTag1
  Scenario: 3NA AkordeonFizyPremiumaGelPremiumaGec
    When I will see img:accordion_premium_header in 8.0 seconds
    When I will click img:accordion_expand_button with 0.2 threshold

    When I will see img:accordion_premium_big_field
    When I will see img:accordion_cancel_button
    When I will click img:accordion_get_premium_button

    When I will see img:buyable_memberships_header
    Given I will click ai:search