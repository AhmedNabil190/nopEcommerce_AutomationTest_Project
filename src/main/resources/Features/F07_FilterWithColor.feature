@smoke
Feature: Filtering categories with color
  Background: user must Login first
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    Then user logged in successfully

    Scenario: user can filter shoesCategory With Color
      Given user hoover on Apperal category
      When user select shoes subcategory
      And user Choose a specfic color
      Then filter Applied successfully