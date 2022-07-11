@smoke
Feature: user can select any category successfully

  Background: user must Login first
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    Then user logged in successfully

  Scenario: user can select categories with subcategories
    Given user hoover on random category
    When user select a subcategory
    Then subcategory opened successfully