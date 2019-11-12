Feature: HELPER

  Background:
    Given I will wait 10 seconds

  Scenario: helper
    When I will get accordion_premium_header SS by id:"com.turkcell.gncplay:id/header"
    When I will get accordion_expand_button SS by id:"com.turkcell.gncplay:id/expandButton"
    When I will wait 10 seconds
    When I will get accordion_cancel_button SS by id:"com.turkcell.gncplay:id/expandButton"
    When I will get accordion_get_premium_button SS by id:"com.turkcell.gncplay:id/btnFirst"
    When I will get accordion_premium_big_field SS by xpath:"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"
    When I will wait 10 seconds
    When I will get buyable_memberships_header SS by id:"com.turkcell.gncplay:id/header"


  @androidSahin
    #TDSS-993
  Scenario: 3NA AkordeonFizyPremiumaGelPremiumaGec
    When I will see img:accordion_premium_header
    When I will click img:accordion_expand_button

    When I will see img:accordion_premium_big_field
    When I will see img:accordion_cancel_button
    When I will click img:accordion_get_premium_button

    When I will see img:buyable_memberships_header



