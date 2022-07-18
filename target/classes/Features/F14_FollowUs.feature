@smoke
Feature: user can open any link
  Scenario: opening Links (HappyScenario)
    Given user CLick on "https://www.facebook.com/nopCommerce" Link
    When user CLick on "https://twitter.com/nopCommerce" Link2
    And  user CLick on "https://www.youtube.com/user/nopCommerce" Link3
    Then user CLick on "https://demo.nopcommerce.com/new-online-store-is-open" Link4
