@smoke
Feature: user can selectAny tags in Category

  Background: user must Login first
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    Then user logged in successfully

  Scenario Outline: user Select Any tag successfully
    Given user Navigate to ant Category
    When user Select <Taggg>
    Then <Taggg> Selected Successfully
    Examples:
      | Taggg   |
      | awesome |
      | cool    |
      | nice    |
