@smoke
Feature: Change Currency
  Background: user Must Login First
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    Then user logged in successfully

    Scenario: user Can Change Currency successfully
      Given user Selects Euro From TopLeft List
      Then Proudcts must be changed to Euro