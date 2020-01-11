@featureTag
Feature: Fizy Anasayfa

  Background:
    Given I will wait 3 seconds

  @scenarioTag
  Scenario: 3NA AkordeonFizyPremiumaGelPremiumaGec
    Given I will click ai:search
    When I will see img:accordion_premium_header
    When I will click img:accordion_expand_button

    When I will see img:accordion_premium_big_field
    When I will see img:accordion_cancel_button
    When I will click img:accordion_get_premium_button

    When I will see img:buyable_memberships_header