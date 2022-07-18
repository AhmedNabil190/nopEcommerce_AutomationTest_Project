@smoke
Feature: user can add item to wish list successfully

  Background: user must Login first
    Given user navigate to Login page
    When type "abaashelmy@gmail.com" and "123123"
    And Click on Login button
    Then user logged in successfully

  Scenario: user Add first item to wish list and check alert message
    Given go to item page
    When click on add to wish list and check alert message
    Then go back to home page

  Scenario: user Add item to wish list and check Counter
    Given go to item page
    When click on add to wish list and check alert message
    And go back to home page
    And check counter of wishlist
    And go to Wish List Page
    Then Items Added successfully