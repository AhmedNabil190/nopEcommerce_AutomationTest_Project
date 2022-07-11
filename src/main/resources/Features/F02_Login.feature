@smoke
Feature: Login Functionality

  Scenario: user Login in (Happy Scenario)
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    Then user logged in successfully

  Scenario: user Login in (Negative Scenario)
    Given user navigate to Login page Negative
    When typee "abaashelmmy@gmail.com" and "123122"
    And Click on Login button Negative
    Then user can not login





