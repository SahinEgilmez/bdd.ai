@android
Feature: AI Tosla

  Background:
    Given I will wait 10 seconds
    When I will enter 190505
    Given I will wait 2 seconds

  @tosla
  Scenario: Arama Butonu
    When I will click ai:search
    When I will click img:search button with 0.9 threshold
    Then I will see "Arama"
    And I will see img:search field

  Scenario: Profil/Ayarlar Butonu
    When I will click img:user
    Then I will see "Profilin"

  Scenario: Bakiye Metni & Bakiye Alanı
    When I will see img:bakiye
    Then I will see "Bakiyen"
    And I will see img:big price view with 0.9 threshold

    When I will swipe up
    Then I will not see img:bakiye with
    And I will not see "Bakiyen"

    When I will click img:small price view
    Then I will wait 2 seconds
    And I will see img:mor para yukle layout

    When I will click "Para Çek"
    Then I will see img:kirmizi para cek layout
    And I will not see img:mor para yukle layout

  Scenario: Tosla Butonu
    When I will click img:tosla button
    Then I will see "Tosla"
    And I will see img:turkuaz gonder layout

    When I will click "İste"
    Then I will see img:sari iste layout

    When I will click "Öde"
    Then I will see img:turkuaz ode layout

    When I will click img:firma search bar
    Then I will enter PUBG
    And I will see img:pubg logo small

    When I will click img:pubg mobil layout
    Then I will see img:pubg toolbar
    And I will see img:pubg logo big
    And I will see img:kim gorsun layout


