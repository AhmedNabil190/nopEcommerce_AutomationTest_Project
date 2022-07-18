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

  Scenario: user can select categories with subcategories2
    Given user hoover on random category2
    When user select a subcategory2
    Then subcategory2 opened successfully

  Scenario: user can select categories with subcategories3
    Given user hoover on random category3
    When user select a subcategory3
    Then subcategory3 opened successfully

