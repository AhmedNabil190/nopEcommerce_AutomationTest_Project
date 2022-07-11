@smoke
Feature: user can add any items to compare
  Background: user must Login first
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    Then user logged in successfully

    Scenario: user adding items to compare list
      Given user add First Item to compare list and check alert
      When user add Second Item to compare list and check alert
      And user navigate to compare list
      Then items should be added successfully
