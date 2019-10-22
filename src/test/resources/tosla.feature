@android
Feature: AI Examples

  Background:
    Given I will wait 10 seconds
    When I will enter 190505

  Scenario: 1A akbank
    When I will click ai:search
    Then I will wait 2 seconds

    When I will click img:search field with 0.30 threshold
    Then I will enter Hasan
    Then I will wait 2 seconds
#
#    When I will click "Hasan Kaya"
#    Then I will wait 2 seconds
#
#    When I will see "Henüz hiçbir toslama yok."
#    Then I will wait 2 seconds

  Scenario: EKRAN AKIŞLARI - Ana Sayfa
    When I will click img:user
    Then I will see "Profilin"

  Scenario: Bakiye Metni
    Given I will wait 3 seconds
    When I will see img:bakiye with 0.75 threshold
    Then I will not see "Bakiyen"
    When I will swipe up

    Then I will not see "Bakiyen"
    When I will not see img:bakiye with 0.75 threshold

  Scenario: helper
    When I will get user SS by xpath:"//android.widget.ImageButton[@content-desc='Yukarı git']"
    When I will get bakiye SS by id:"com.akode.tosla.debug:id/mainToolbarLinearLayout"
    When I will get tosla_button SS by id:"com.akode.tosla.debug:id/mainToslaFAB"
    When I will get toolbar_arrow SS by id:"com.akode.tosla.debug:id/mainToolbarArrow"
    When I will get toolbar_title SS by id:"com.akode.tosla.debug:id/mainToolbarTitle"

