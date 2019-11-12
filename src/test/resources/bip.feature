@android
Feature: AI Tosla

  Background:
    Given I will wait 1 seconds

  @bip
  Scenario: Yeni Sohbet
    When I will click img:message
    Then I will see "Yeni Sohbet"
    And I will click ai:search
    When I will enter Efkan G
    Then I will click "Efkan Günbay"

    Given I will wait 5 seconds
    And I will click img:stickers
    And I will click img:CAPS
    Given I will wait 5 seconds

  @bip
  Scenario: Çeviri
    Given I will click img:message
    And I will see "Yeni Sohbet"

    When I will click ai:search
    Then I will enter Galax
    And I will click "Galaxy"

    When I will click "Mesajınızı yazın"
    Then I will enter Selam
    And I will long press "Selam"
    And I will wait 2 seconds

    When I will click img:translate
    Then I will see "Çeviri İzni"
    And I will click "İZİN VERME"